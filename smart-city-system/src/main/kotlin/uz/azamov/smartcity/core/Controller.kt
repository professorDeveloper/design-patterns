package uz.azamov.smartcity.core

import uz.azamov.smartcity.core.adapters.WeatherAdapter
import uz.azamov.smartcity.core.builders.SmartStreet
import uz.azamov.smartcity.core.factories.DeviceFactory
import uz.azamov.smartcity.core.proxy.SecurityProxy
import uz.azamov.smartcity.core.singleton.Log
import uz.azamov.smartcity.modules.energy.EnergySystem
import uz.azamov.smartcity.modules.lighting.LightingSystem
import uz.azamov.smartcity.modules.security.SecuritySystem
import uz.azamov.smartcity.modules.transport.TransportSystem
import java.util.Locale
import java.util.Scanner

object Controller {
    private val lightingSystem = LightingSystem()
    private val securitySystem = SecuritySystem()
    private val energySystem = EnergySystem()
    private val transportSystem = TransportSystem()

    private val weatherAdapter = WeatherAdapter()
    private val deviceFactory = DeviceFactory()
    private val securityProxy = SecurityProxy(energySystem, lightingSystem)
    private val builtStreets = mutableListOf<SmartStreet>()

    fun showCityReport() {
        println("\n========= SHAHAR MONITORINGI VA HISOBOT =========")
        println(lightingSystem.getSystemReport())
        println(energySystem.getSystemReport())
        println(securitySystem.getSecurityReport())
        println(transportSystem.getTrafficReport())
        if (builtStreets.isEmpty()) {
            println("Hozircha qurilgan ko'chalar yo'q.")
        } else {
            println("Qurilgan ko'chalar (${builtStreets.size} ta):")
            builtStreets.forEach { println(" - ${it.getStreetInfo()}") }
        }
        println("===================================================\n")
    }

    fun buildNewStreet(scanner: Scanner) {
        println("\n--- Yangi obyekt qurish (Builder + Factory Method) ---")
        print("Ko'cha nomini kiriting: ")
        val name = scanner.nextLine().trim().ifBlank { "Noma'lum ko'cha" }

        print("Nechta chiroq o'rnatiladi? ")
        val lightsCount = scanner.nextLine().toIntOrNull()?.coerceAtLeast(0) ?: 0

        print("Nechta kamera o'rnatiladi? ")
        val camerasCount = scanner.nextLine().toIntOrNull()?.coerceAtLeast(0) ?: 0

        print("Svetafor o'rnatilsinmi? (ha/yo'q): ")
        val wantsTrafficLight = scanner.nextLine().trim().lowercase() == "ha"

        val builder = SmartStreet.Builder(name)
            .addLights(lightsCount)
            .addCameras(camerasCount)
        if (wantsTrafficLight) builder.addTrafficLight()
        val street = builder.build()
        builtStreets.add(street)

        repeat(lightsCount) { deviceFactory.createDevice("StreetLight")?.operate() }
        repeat(camerasCount) { deviceFactory.createDevice("Camera")?.operate() }
        if (camerasCount > 0) securitySystem.addCameras(camerasCount)

        Log.info("Yangi ko'cha qurildi: ${street.getStreetInfo()}")
    }

    fun securityMenu(scanner: Scanner) {
        println(
            """
            --- Xavfsizlik va maxsus amaliyotlar ---
            1. Kamera qo'shish
            2. Transport favqulodda holatini yoqish
            3. Favqulodda holatni bekor qilish
            4. Favqulodda rejimni proksi orqali faollashtirish
            5. Favqulodda rejimni proksi orqali o'chirish
            6. Xavfsizlik hisobotini ko'rish
            0. Orqaga qaytish
            """.trimIndent()
        )
        print("Tanlovingiz: ")
        when (scanner.nextLine()) {
            "1" -> {
                print("Nechta kamera qo'shiladi? ")
                val count = scanner.nextLine().toIntOrNull()?.coerceAtLeast(0) ?: 0
                securitySystem.addCameras(count)
            }

            "2" -> securitySystem.trafficEmergency()
            "3" -> securitySystem.resetEmergencyState()

            "4" -> {
                print("Kirish kodini kiriting: ")
                securityProxy.activateEmergencyMode(scanner.nextLine().trim())
            }

            "5" -> {
                print("Kirish kodini kiriting: ")
                securityProxy.deactivateEmergencyMode(scanner.nextLine().trim())
            }

            "6" -> println(securitySystem.getSecurityReport())
            "0" -> {}
            else -> println("Noto'g'ri tanlov.")
        }
    }

    fun connectToWeatherService() {
        println("\n--- Tashqi ob-havo tizimiga ulanish (Adapter) ---")
        val weather = weatherAdapter.getCurrentWeather()
        println("Holat: ${weather.description}")
        println("Harorat: ${formatTemperature(weather.temperatureCelsius)}°C")

        when (weather.condition) {
            "STORM", "RAIN" -> {
                println("Yomon ob-havo aniqlandi -> yoritish tizimi to'liq quvvatda yoqilmoqda.")
                lightingSystem.turnOnAll()
            }

            else -> {
                println("Ob-havo barqaror -> yoritish tizimi eko rejimga o'tkazilmoqda.")
                lightingSystem.setEcoMode()
            }
        }
    }

    fun energyMenu(scanner: Scanner) {
        println(
            """
            --- Energiya boshqaruvi ---
            1. Energiya sarflash
            2. Energiyani bo'shatish
            3. Eko rejimni yoqish/o'chirish
            4. Yuklanishni tekshirish
            5. Hisobotni ko'rish
            0. Orqaga qaytish
            """.trimIndent()
        )
        print("Tanlovingiz: ")
        when (scanner.nextLine()) {
            "1" -> {
                print("Qancha energiya sarflanadi (kWh)? ")
                val amount = scanner.nextLine().toDoubleOrNull()?.coerceAtLeast(0.0) ?: 0.0
                energySystem.consumeEnergy(amount)
            }

            "2" -> {
                print("Qancha energiya bo'shatiladi (kWh)? ")
                val amount = scanner.nextLine().toDoubleOrNull()?.coerceAtLeast(0.0) ?: 0.0
                energySystem.freeEnergy(amount)
            }

            "3" -> {
                print("Eko rejim yoqilsinmi? (ha/yo'q): ")
                energySystem.setEcoMode(scanner.nextLine().trim().lowercase() == "ha")
            }

            "4" -> {
                val overloaded = energySystem.checkOverload()
                println(if (overloaded) "Diqqat: tizim haddan tashqari yuklangan!" else "Tizim normal holatda ishlamoqda.")
            }

            "5" -> println(energySystem.getSystemReport())
            "0" -> {}
            else -> println("Noto'g'ri tanlov.")
        }
    }

    private fun formatTemperature(value: Double): String = String.format(Locale.US, "%.1f", value)
}