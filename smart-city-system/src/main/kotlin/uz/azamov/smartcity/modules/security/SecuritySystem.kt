package uz.azamov.smartcity.modules.security

class SecuritySystem {
    private var cameraCount: Int = 0
    private var isEmergencyState: Boolean = false
    fun addCameras(count: Int) {
        cameraCount += count
        println("$count ta kamera qo'shildi. Jami kameralar soni: $cameraCount.")
    }

    fun trafficEmergency() {
        isEmergencyState = true
        println("Barcha kameralar favqulotda ishga tuhsdi.")
    }

    fun resetEmergencyState() {
        isEmergencyState = false
        println("Favqulotda holat bekor qilindi. Kameralar normal ish rejimiga qaytdi.")
    }

    fun getSecurityReport(): String {
        return "Xavfsizlik tizimi hisobot: Kameralar soni: $cameraCount, Favqulotda holat: ${if (isEmergencyState) "faol" else "faol emas"}."
    }
}