package uz.azamov.smartcity

import uz.azamov.smartcity.core.Controller
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    while (true) {
        println(
            """
                ======= Asosiy Menyu =======
                1.Shahar monitoringi va hisobot
                2.Yangi obyektlar qurish
                3.Xavfsizlik va maxsus amaliyotlar
                4.Tashqi ob-havo tizimiga ulanish
                5.Energiya boshqaruvi
                6.Chiqish
       """.trimIndent()
        )
        print("Tanlovingizni kiriting (1-6): ")
        val choose = scanner.nextLine()
        when (choose) {
            "1" -> {
                Controller.showCityReport()
            }

            "2" -> {
                Controller.buildNewStreet(scanner)
            }

            "3" -> {
                Controller.securityMenu(scanner)
            }

            "4" -> {
                Controller.connectToWeatherService()
            }

            "5" -> {
                Controller.energyMenu(scanner)
            }

            "6" -> {
                println("Dasturdan chiqish...")
                break
            }

            else -> {
                println("Invalid choice. Please try again.")
            }
        }

    }
}
