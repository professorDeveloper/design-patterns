package structural.bridge.device_example.devices

class XiaomiDevice {
    fun startEngine() {
        println("Xiaomi device engine started")
    }

    fun adjustVolume(level: Double) {
        println("Xiaomi device volume adjusted to $level")
    }
}