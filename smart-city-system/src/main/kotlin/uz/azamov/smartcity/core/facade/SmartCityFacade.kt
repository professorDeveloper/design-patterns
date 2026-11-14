package uz.azamov.smartcity.core.facade

import uz.azamov.smartcity.core.adapters.WeatherAdapter
import uz.azamov.smartcity.core.adapters.WeatherService
import uz.azamov.smartcity.core.builders.SmartStreet
import uz.azamov.smartcity.core.proxy.EmergencyService
import uz.azamov.smartcity.core.proxy.SecurityProxy
import uz.azamov.smartcity.core.singleton.Log
import uz.azamov.smartcity.modules.energy.EnergySystem
import uz.azamov.smartcity.modules.lighting.LightingSystem
import uz.azamov.smartcity.modules.security.SecuritySystem
import uz.azamov.smartcity.modules.transport.TrafficLevel
import uz.azamov.smartcity.modules.transport.TransportSystem
import java.util.Locale

class SmartCityFacade(private val weatherService: WeatherService = WeatherAdapter()) {
    val lighting = LightingSystem()
    val energy = EnergySystem()
    val security = SecuritySystem()
    val transport = TransportSystem()

    private val emergency = EmergencyService(lighting, energy)
    private val streets = mutableListOf<SmartStreet>()

    fun cityReport() = buildString {
        appendLine("========= SHAHAR MONITORINGI VA HISOBOT =========")
        appendLine(lighting.report())
        appendLine(energy.report())
        appendLine(security.report())
        appendLine(transport.report())
        appendLine("Favqulodda rejim: ${if (emergency.isActive) "faol" else "faol emas"}")
        if (streets.isEmpty()) appendLine("Hozircha qurilgan ko'chalar yo'q.")
        else streets.forEach { appendLine(" - ${it.info()}") }
        append("=================================================")
    }

    fun buildStreet(name: String, lights: Int, cameras: Int, withTrafficLight: Boolean): SmartStreet {
        val builder = SmartStreet.Builder(name).addLights(lights).addCameras(cameras)
        if (withTrafficLight) builder.addTrafficLight()
        val street = builder.build()

        streets += street
        lighting.installLamps(street.lightsCount)
        security.addCameras(street.camerasCount)
        if (street.hasTrafficLight) transport.addTrafficLight()

        Log.info("Yangi ko'cha qurildi: ${street.name}")
        return street
    }

    fun addCameras(count: Int): String {
        security.addCameras(count)
        return "$count ta kamera qo'shildi. Jami: ${security.cameraCount} ta."
    }

    fun trafficEmergency(): String {
        security.trafficEmergency()
        transport.updateTrafficLevel(TrafficLevel.HIGH)
        return "Favqulodda holat: kameralar faol, yashil chiroq ${TrafficLevel.HIGH.greenLightSeconds} soniya."
    }

    fun resetTrafficEmergency(): String {
        security.resetEmergency()
        transport.updateTrafficLevel(TrafficLevel.NORMAL)
        return "Favqulodda holat bekor qilindi."
    }

    fun activateEmergency(accessCode: String) = SecurityProxy(emergency, accessCode).activate()

    fun deactivateEmergency(accessCode: String) = SecurityProxy(emergency, accessCode).deactivate()

    fun connectToWeatherService(): String {
        val weather = weatherService.getCurrentWeather()
        val action = when {
            emergency.isActive -> "Favqulodda rejim faol: chiroqlar 100% da qoldi."
            weather.condition.isBad -> {
                lighting.turnOnAll()
                "Ob-havo yomon: chiroqlar 100% ga yoqildi."
            }
            else -> {
                lighting.setEcoMode()
                "Ob-havo yaxshi: chiroqlar eko rejimda (50%)."
            }
        }
        return "Holat: ${weather.condition.description}\n" +
            "Harorat: ${String.format(Locale.US, "%.1f", weather.temperatureCelsius)}°C\n" +
            action
    }

    fun consumeEnergy(amount: Double): String {
        val consumed = energy.consume(amount)
        val message = String.format(Locale.US, "Sarflandi: %.1f kWh.", consumed)
        return if (energy.isOverloaded) "$message Ogohlantirish: tizim haddan tashqari yuklandi!" else message
    }

    fun releaseEnergy(amount: Double) =
        String.format(Locale.US, "Bo'shatildi: %.1f kWh.", energy.release(amount))

    fun setEcoMode(enabled: Boolean): String {
        if (emergency.isActive) return "Favqulodda rejim faol, eko rejimni o'zgartirib bo'lmaydi."
        energy.setEcoMode(enabled)
        return if (enabled) {
            lighting.turnOffAll()
            "Eko rejim yoqildi: energiya sarfi kamayadi, chiroqlar o'chirildi."
        } else {
            lighting.turnOnAll()
            "Eko rejim o'chirildi: energiya sarfi normal, chiroqlar 100% ga yoqildi."
        }
    }

    fun checkOverload() =
        if (energy.isOverloaded) "Diqqat: tizim haddan tashqari yuklangan!" else "Tizim normal ishlamoqda."

    fun setTrafficLevel(level: TrafficLevel): String {
        transport.updateTrafficLevel(level)
        return "Tirbandlik ${level.title}: yashil chiroq ${level.greenLightSeconds} soniya."
    }
}
