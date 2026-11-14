package uz.azamov.smartcity.core.proxy

import uz.azamov.smartcity.modules.energy.EnergySystem
import uz.azamov.smartcity.modules.lighting.LightingSystem

interface EmergencyControl {
    val isActive: Boolean
    fun activate(): String
    fun deactivate(): String
}

class EmergencyService(
    private val lighting: LightingSystem,
    private val energy: EnergySystem
) : EmergencyControl {
    override var isActive = false
        private set

    override fun activate(): String {
        if (isActive) return "Favqulodda rejim allaqachon yoqilgan."
        energy.setEcoMode(false)
        lighting.turnOnAll()
        isActive = true
        return "Favqulodda rejim yoqildi: chiroqlar 100%, energiya to'liq quvvatda."
    }

    override fun deactivate(): String {
        if (!isActive) return "Favqulodda rejim allaqachon o'chirilgan."
        lighting.setEcoMode()
        isActive = false
        return "Favqulodda rejim o'chirildi: chiroqlar eko rejimda (50%)."
    }
}
