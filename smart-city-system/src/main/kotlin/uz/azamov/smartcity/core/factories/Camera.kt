package uz.azamov.smartcity.core.factories

class Camera : Device {
    override fun getName(): String {
        return "Camera"
    }

    override fun operate() {
        println("Camera is operating.")
    }
}