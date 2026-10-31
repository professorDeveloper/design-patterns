package structural.bridge.device_example

import structural.bridge.device_example.adaptor.XiaomiDeviceAdaptor
import structural.bridge.device_example.devices.Radio
import structural.bridge.device_example.devices.Tv
import structural.bridge.device_example.devices.XiaomiDevice

fun main(args: Array<String>) {
    val radio = Radio()
    val tv = Tv()
    val xiaomiDevice = XiaomiDevice()

    val xiaomiDeviceAdapter = XiaomiDeviceAdaptor(xiaomiDevice)

    radio.turnOn()
    radio.setVolume(5)

    xiaomiDeviceAdapter.turnOn()
    xiaomiDeviceAdapter.setVolume(10)
}