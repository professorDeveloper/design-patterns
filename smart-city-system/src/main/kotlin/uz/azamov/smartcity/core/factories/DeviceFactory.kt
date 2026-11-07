package uz.azamov.smartcity.core.factories

class DeviceFactory {
    fun createDevice(type: String): Device? {
        return when (type) {
            "StreetLight" -> StreetLight()
            "Camera" -> Camera()
            else -> null
        }
    }

}