package uz.azamov.smartcity.modules.energy

class EnergySystem {
    private var totalConsumption: Double = 0.0
    private var ecoModeEnabled: Boolean = false
    private val maxCapacity: Double = 10000.0
    fun consumeEnergy(amount: Double) {
        if (ecoModeEnabled) {
            println("Eko rejimi yoqilgan. Energiya sarfi kamayadi.")
            totalConsumption += amount * 0.5
        } else {
            totalConsumption += amount
        }

        if (totalConsumption > maxCapacity) {
            println("Ogohlantirish: Energiya tizimi haddan tashqari yuklanmoqda! Jami sarf: $totalConsumption kWh, Maksimal quvvat: $maxCapacity kWh.")
        }
    }

    fun freeEnergy(amount: Double) {
        totalConsumption -= amount
        if (totalConsumption < 0) {
            totalConsumption = 0.0
        }
    }

    fun setEcoMode(enabled: Boolean) {
        ecoModeEnabled = enabled
        if (ecoModeEnabled) {
            println("Eko rejimi yoqilgan. Energiya sarfi kamayadi.")
        } else {
            println("Eko rejimi o'chirilgan. Energiya sarfi normal holatda.")
        }
    }

    fun checkOverload(): Boolean {
        return totalConsumption > maxCapacity
    }

    fun getSystemReport(): String {
        return "Energiya tizimi hisobot: Jami sarf: $totalConsumption kWh, Maksimal quvvat: $maxCapacity kWh, Eko rejimi: ${if (ecoModeEnabled) "yoqilgan" else "o'chirilgan"}."
    }
}