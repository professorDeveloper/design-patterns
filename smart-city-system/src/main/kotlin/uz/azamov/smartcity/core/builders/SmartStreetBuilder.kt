package uz.azamov.smartcity.core.builders


class SmartStreet private constructor(
    val name: String,
    val lightsCount: Int,
    val camerasCount: Int,
    val hasTrafficLight: Boolean
) {
    fun getStreetInfo(): String {
        val trafficLightInfo = if (hasTrafficLight) "bor" else "yo'q"
        return "Ko'cha nomi: $name | Chiroqlar: $lightsCount ta | Kameralar: $camerasCount ta | Svetafor: $trafficLightInfo"
    }

    class Builder(private val name: String) {
        private var lightsCount: Int = 0
        private var camerasCount: Int = 0
        private var hasTrafficLight: Boolean = false

        init {
            println("Builder: '$name' ko'chasini qurish boshlandi...")
        }

        fun addLights(count: Int) = apply {
            this.lightsCount += count
            println("Builder: $count ta chiroq o'rnatildi.")
        }

        fun addCameras(count: Int) = apply {
            this.camerasCount += count
            println("Builder: $count ta kamera o'rnatildi.")
        }

        fun addTrafficLight() = apply {
            this.hasTrafficLight = true
            println("Builder: Svetafor o'rnatildi.")
        }

        fun build(): SmartStreet {
            println("Builder: '$name' ko'chasi to'liq yig'ildi.")
            return SmartStreet(name, lightsCount, camerasCount, hasTrafficLight)
        }
    }
}