package uz.azamov.smartcity.core.factories

interface Device {
    val type: DeviceType
    fun operate(): String
}
