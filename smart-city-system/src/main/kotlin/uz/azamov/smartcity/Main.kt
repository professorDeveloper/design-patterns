package uz.azamov.smartcity

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
        val choose = scanner.nextLine()
        when (choose) {
            "1" -> {

            }

            "2" -> {
            }

            "3" -> {
            }

            "4" -> {
            }

            "5" -> {

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
