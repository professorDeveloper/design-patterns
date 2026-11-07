package uz.azamov.smartcity.core.factories

class StreetLight4 : Device {
    override fun getName( ): String {
        return "Street Light"
    }

    override fun operate() {
        println("Street light is operating.")
    }
}