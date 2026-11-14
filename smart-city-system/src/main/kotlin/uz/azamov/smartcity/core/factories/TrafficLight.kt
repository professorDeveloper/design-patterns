package uz.azamov.smartcity.core.factories

class TrafficLight : Device {
    override val type = DeviceType.TRAFFIC_LIGHT
    override fun operate() = "Svetafor ishga tushdi"
}
