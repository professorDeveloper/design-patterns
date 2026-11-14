package uz.azamov.smartcity.core.proxy

import uz.azamov.smartcity.core.singleton.Log

class SecurityProxy(
    private val target: EmergencyControl,
    private val accessCode: String
) : EmergencyControl {

    override val isActive get() = target.isActive

    override fun activate() = if (hasAccess()) target.activate() else denied()

    override fun deactivate() = if (hasAccess()) target.deactivate() else denied()

    private fun hasAccess() = accessCode == ACCESS_CODE

    private fun denied(): String {
        Log.error("Favqulodda rejimga kirish rad etildi: kod noto'g'ri")
        return "Kirish rad etildi."
    }

    companion object {
        const val ACCESS_CODE = "SC-2026"
    }
}
