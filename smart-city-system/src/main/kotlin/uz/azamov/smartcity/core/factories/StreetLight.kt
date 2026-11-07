package uz.azamov.smartcity.core.factories

class StreetLight : Device {
    override fun getName(): String {
        return "Street Light"
    }

    override fun operate() {
        println("Street light is operating.")
    }
}