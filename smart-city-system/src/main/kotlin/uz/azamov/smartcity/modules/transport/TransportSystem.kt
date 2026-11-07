package uz.azamov.smartcity.modules.transport

class TransportSystem {
    private var trafficLevel = "NORMAL"
    private var greenLightDuration = 30 // second

    fun updateTrafficLevel(level: Int) {
        when (trafficLevel) {
            "HIGH" -> {
                greenLightDuration = 60
                println("Transport: Tirbandlik yuqori! Yashil chiroq vaqti 60 soniyaga uzaytirildi.")
            }

            "LOW" -> {
                greenLightDuration = 20
                println("Transport: Yo'llar bo'sh. Yashil chiroq vaqti 20 soniyaga tushirildi.")
            }

            else -> {
                greenLightDuration = 30
                println("Transport: Harakat normal. Yashil chiroq vaqti 30 soniya.")
            }
        }
    }

    fun getTrafficReport(): String {
        return "Transport tizimi hisobot: Tirbandlik darajasi: $trafficLevel, Yashil chiroq vaqti: $greenLightDuration soniya."
    }

}