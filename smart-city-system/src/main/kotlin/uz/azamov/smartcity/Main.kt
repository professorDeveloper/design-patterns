package uz.azamov.smartcity

import uz.azamov.smartcity.core.facade.SmartCityFacade
import uz.azamov.smartcity.core.utils.ask
import uz.azamov.smartcity.core.utils.askAmount
import uz.azamov.smartcity.core.utils.askCount
import uz.azamov.smartcity.core.utils.askYesNo
import uz.azamov.smartcity.core.utils.menu
import uz.azamov.smartcity.modules.transport.TrafficLevel

private val facade = SmartCityFacade()


fun main() {
    while (true) {
        val choice = menu(
            "Asosiy menyu",
            "Shahar monitoringi va hisobot",
            "Yangi ko'cha qurish",
            "Xavfsizlik va maxsus amaliyotlar",
            "Tashqi ob-havo tizimiga ulanish",
            "Energiya boshqaruvi",
            "Transport boshqaruvi",
            exit = "Chiqish"
        )
        when (choice) {
            "1" -> println(facade.cityReport())
            "2" -> buildStreetMenu()
            "3" -> securityMenu()
            "4" -> println(facade.connectToWeatherService())
            "5" -> energyMenu()
            "6" -> transportMenu()
            "0", null -> return println("Dasturdan chiqildi.")
            else -> println("Noto'g'ri tanlov.")
        }
    }
}

private fun buildStreetMenu() {
    val name = ask("Ko'cha nomi: ")?.ifBlank { "Noma'lum ko'cha" } ?: return
    val lights = askCount("Nechta chiroq o'rnatiladi? ") ?: return
    val cameras = askCount("Nechta kamera o'rnatiladi? ") ?: return
    val withTrafficLight = askYesNo("Svetafor o'rnatilsinmi?") ?: return

    val street = facade.buildStreet(name, lights, cameras, withTrafficLight)
    street.devices.groupingBy { it.operate() }.eachCount().forEach { (status, count) -> println("$status: $count ta") }
    println("Ko'cha qurildi: ${street.info()}")
}

private fun securityMenu() {
    while (true) {
        val choice = menu(
            "Xavfsizlik va maxsus amaliyotlar",
            "Kamera qo'shish",
            "Transport favqulodda holatini yoqish",
            "Favqulodda holatni bekor qilish",
            "Favqulodda rejimni proksi orqali yoqish",
            "Favqulodda rejimni proksi orqali o'chirish",
            "Xavfsizlik hisoboti"
        )
        when (choice) {
            "1" -> askCount("Nechta kamera qo'shiladi? ")?.let { println(facade.addCameras(it)) }
            "2" -> println(facade.trafficEmergency())
            "3" -> println(facade.resetTrafficEmergency())
            "4" -> ask("Kirish kodi: ")?.let { println(facade.activateEmergency(it)) }
            "5" -> ask("Kirish kodi: ")?.let { println(facade.deactivateEmergency(it)) }
            "6" -> println(facade.security.report())
            "0", null -> return
            else -> println("Noto'g'ri tanlov.")
        }
    }
}

private fun energyMenu() {
    while (true) {
        val choice = menu(
            "Energiya boshqaruvi",
            "Energiya sarflash",
            "Energiyani bo'shatish",
            "Eko rejimni yoqish/o'chirish",
            "Yuklanishni tekshirish",
            "Energiya hisoboti"
        )
        when (choice) {
            "1" -> askAmount("Qancha energiya sarflanadi (kWh)? ")?.let { println(facade.consumeEnergy(it)) }
            "2" -> askAmount("Qancha energiya bo'shatiladi (kWh)? ")?.let { println(facade.releaseEnergy(it)) }
            "3" -> askYesNo("Eko rejim yoqilsinmi?")?.let { println(facade.setEcoMode(it)) }
            "4" -> println(facade.checkOverload())
            "5" -> println(facade.energy.report())
            "0", null -> return
            else -> println("Noto'g'ri tanlov.")
        }
    }
}

private fun transportMenu() {
    val levels = TrafficLevel.entries
    while (true) {
        val options = levels.map { "Tirbandlik: ${it.title}" } + "Transport hisoboti"
        val choice = menu("Transport boshqaruvi", *options.toTypedArray()) ?: return
        val index = choice.toIntOrNull()?.minus(1)
        when {
            choice == "0" -> return
            index == levels.size -> println(facade.transport.report())
            index != null && index in levels.indices -> println(facade.setTrafficLevel(levels[index]))
            else -> println("Noto'g'ri tanlov.")
        }
    }
}



