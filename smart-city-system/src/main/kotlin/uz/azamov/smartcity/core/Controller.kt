package uz.azamov.smartcity.core

import uz.azamov.smartcity.core.adapters.WeatherAdapter
import uz.azamov.smartcity.core.builders.SmartStreetBuilder
import uz.azamov.smartcity.core.factories.DeviceFactory
import uz.azamov.smartcity.core.proxy.SecurityProxy
import uz.azamov.smartcity.modules.energy.EnergySystem
import uz.azamov.smartcity.modules.lighting.LightingSystem
import uz.azamov.smartcity.modules.security.SecuritySystem
import uz.azamov.smartcity.modules.transport.TransportSystem

object Controller {
    private val lightingSystem = LightingSystem()
    private val securitySystem = SecuritySystem()
    private val energySystem = EnergySystem()
    private val transportSystem = TransportSystem()



    private val weatherAdapter = WeatherAdapter()
    private val deviceFactory = DeviceFactory()
    private val smartStreetBuilder = SmartStreetBuilder()
    private val securityProxy = SecurityProxy(energySystem, lightingSystem)


}