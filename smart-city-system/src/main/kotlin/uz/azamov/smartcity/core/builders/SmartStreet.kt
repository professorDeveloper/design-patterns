package uz.azamov.smartcity.core.builders

import uz.azamov.smartcity.core.factories.Device
import uz.azamov.smartcity.core.factories.DeviceFactory
import uz.azamov.smartcity.core.factories.DeviceType

class SmartStreet private constructor(
    val name: String,
    val devices: List<Device>
) {
    val lightsCount get() = devices.count { it.type == DeviceType.STREET_LIGHT }
    val camerasCount get() = devices.count { it.type == DeviceType.CAMERA }
    val hasTrafficLight get() = devices.any { it.type == DeviceType.TRAFFIC_LIGHT }

    fun info() = "$name | chiroqlar: $lightsCount ta | kameralar: $camerasCount ta | " +
        "svetafor: ${if (hasTrafficLight) "bor" else "yo'q"}"

    class Builder(private val name: String, private val factory: DeviceFactory = DeviceFactory()) {
        private val devices = mutableListOf<Device>()

        fun addLights(count: Int) = add(DeviceType.STREET_LIGHT, count)

        fun addCameras(count: Int) = add(DeviceType.CAMERA, count)

        fun addTrafficLight() = apply {
            if (devices.none { it.type == DeviceType.TRAFFIC_LIGHT }) add(DeviceType.TRAFFIC_LIGHT, 1)
        }

        fun build() = SmartStreet(name, devices.toList())

        private fun add(type: DeviceType, count: Int) = apply {
            repeat(count) { devices += factory.createDevice(type) }
        }
    }
}
