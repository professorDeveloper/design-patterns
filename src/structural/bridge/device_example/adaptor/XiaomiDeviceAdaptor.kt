package structural.bridge.device_example.adaptor

import structural.bridge.device_example.base.Device
import structural.bridge.device_example.devices.XiaomiDevice

class XiaomiDeviceAdaptor(
    private val xiaomiDevice: XiaomiDevice
) : Device {
    override fun turnOn() {
        xiaomiDevice.startEngine()
    }

    override fun setVolume(volume: Int) {
        val level = volume / 100.0
        xiaomiDevice.adjustVolume(level)
    }
}