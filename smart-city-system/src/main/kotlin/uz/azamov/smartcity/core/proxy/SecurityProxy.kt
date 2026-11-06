package uz.azamov.smartcity.core.proxy

import uz.azamov.smartcity.modules.energy.EnergySystem
import uz.azamov.smartcity.modules.lighting.LightingSystem
import uz.azamov.smartcity.modules.security.SecuritySystem

class SecurityProxy(
    private val energySystem: EnergySystem,
    private val lightingSystem: LightingSystem) {

}