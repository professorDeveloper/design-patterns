package uz.azamov.smartcity.core.factories

class DeviceFactory {
    fun createDevice(type: DeviceType): Device = when (type) {
        DeviceType.STREET_LIGHT -> StreetLight()
        DeviceType.CAMERA -> Camera()
        DeviceType.TRAFFIC_LIGHT -> TrafficLight()
    }
}
