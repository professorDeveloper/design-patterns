package uz.azamov.smartcity.core.factories

class Camera : Device {
    override val type = DeviceType.CAMERA
    override fun operate() = "Kamera kuzatuvni boshladi"
}
