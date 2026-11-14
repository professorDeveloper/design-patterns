package uz.azamov.smartcity.modules.lighting

class LightingSystem {
    var lampCount = 0
        private set
    var brightness = 0
        private set

    val isOn get() = brightness > 0

    fun installLamps(count: Int) {
        lampCount += count
    }

    fun turnOnAll() {
        brightness = 100
    }

    fun turnOffAll() {
        brightness = 0
    }

    fun setEcoMode() {
        brightness = 50
    }

    fun report() = "Yoritish: $lampCount ta chiroq, ${if (isOn) "yoqilgan" else "o'chirilgan"}, yorqinlik $brightness%"
}
