package uz.azamov.smartcity.modules.lighting

class LightingSystem {
    private var isOn: Boolean = false
    private var brightness: Int = 0

    fun turnOnAll() {
        isOn = true
        brightness = 100
        println("Energiya tizimi yoqildi. Yorqinlik $brightness% ga o'rnatildi.")
    }

    fun turnOffAll() {
        isOn = false
        brightness = 0
        println("Energiya tizimi o'chirildi. Yorqinlik $brightness% ga o'rnatildi.")
    }

    fun getSystemReport(): String {
        return "Yoritish tizimi hisobot: Tizim holati: ${if (isOn) "yoqilgan" else "o'chirilgan"}, Yorqinlik: $brightness%."
    }


    fun setEcoMode() {
        if (!isOn) {

            println("Energiya tizimi o'chirilgan. Eko rejimini o'rnatish mumkin emas.")
            return
        }
        brightness = 50
        println("Energiya tizimi eko rejimida. Yorqinlik $brightness% ga o'rnatildi.")
    }
}