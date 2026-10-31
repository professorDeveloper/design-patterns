package structural.bridge.device_example.devices

import structural.bridge.device_example.base.Device

class Radio: Device {
    override fun turnOn() {
        println("Radio is turned on")
    }

    override fun setVolume(volume: Int) {
        println("Radio volume set to $volume")
    }
}