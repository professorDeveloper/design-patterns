package structural.bridge.device_example.base

class BasicRemote(val device: Device) {
    fun turnOn() {
        device.turnOn()
    }

    fun setVolume(volume: Int) {
        device.setVolume(volume)
    }
}