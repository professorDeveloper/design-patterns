package uz.azamov.smartcity.core.proxy

import uz.azamov.smartcity.core.singleton.Log
import uz.azamov.smartcity.modules.energy.EnergySystem
import uz.azamov.smartcity.modules.lighting.LightingSystem

class SecurityProxy(
    private val energySystem: EnergySystem,
    private val lightingSystem: LightingSystem
) {
    private val emergencyAccessCode = "SC-2026"
    private var emergencyActive = false

    fun activateEmergencyMode(accessCode: String): Boolean {
        if (accessCode != emergencyAccessCode) {
            Log.error("Favqulodda rejimni yoqishga urinish rad etildi: kirish kodi noto'g'ri.")
            return false
        }

        energySystem.setEcoMode(false)
        lightingSystem.turnOnAll()
        emergencyActive = true
        Log.info("Favqulodda rejim faollashtirildi: barcha chiroqlar yoqildi, energiya to'liq quvvatda.")
        return true
    }

    fun deactivateEmergencyMode(accessCode: String): Boolean {
        if (accessCode != emergencyAccessCode) {
            Log.error("Favqulodda rejimni o'chirishga urinish rad etildi: kirish kodi noto'g'ri.")
            return false
        }

        if (!emergencyActive) {
            Log.info("Favqulodda rejim allaqachon faol emas.")
            return true
        }

        lightingSystem.setEcoMode()
        emergencyActive = false
        Log.info("Favqulodda rejim o'chirildi, tizim normal holatga qaytdi.")
        return true
    }

    fun isEmergencyActive(): Boolean = emergencyActive
}