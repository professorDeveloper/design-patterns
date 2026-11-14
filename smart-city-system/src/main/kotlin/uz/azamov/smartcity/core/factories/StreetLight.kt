package uz.azamov.smartcity.core.factories

class StreetLight : Device {
    override val type = DeviceType.STREET_LIGHT
    override fun operate() = "Ko'cha chirog'i ishga tushdi"
}
