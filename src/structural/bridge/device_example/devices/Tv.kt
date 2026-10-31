package structural.bridge.device_example.devices

import structural.bridge.device_example.base.Device

class Tv : Device {
    override fun turnOn() {
        println("TV is turned on")
    }

    override fun setVolume(volume: Int) {
        println("TV volume set to $volume")
    }
}