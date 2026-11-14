package uz.azamov.smartcity.modules.energy

import java.util.Locale

class EnergySystem(private val maxCapacity: Double = 10_000.0) {
    var totalConsumption = 0.0
        private set
    var isEcoMode = false
        private set

    val isOverloaded get() = totalConsumption > maxCapacity

    fun consume(amount: Double): Double {
        val actual = if (isEcoMode) amount / 2 else amount
        totalConsumption += actual
        return actual
    }

    fun release(amount: Double): Double {
        val released = minOf(amount, totalConsumption)
        totalConsumption -= released
        return released
    }

    fun setEcoMode(enabled: Boolean) {
        isEcoMode = enabled
    }

    fun report() = String.format(
        Locale.US,
        "Energiya: sarf %.1f / %.1f kWh, eko rejim %s",
        totalConsumption, maxCapacity, if (isEcoMode) "yoqilgan" else "o'chirilgan"
    )
}
