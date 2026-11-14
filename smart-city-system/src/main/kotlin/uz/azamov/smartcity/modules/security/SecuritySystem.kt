package uz.azamov.smartcity.modules.security

class SecuritySystem {
    var cameraCount = 0
        private set
    var isEmergency = false
        private set

    fun addCameras(count: Int) {
        cameraCount += count
    }

    fun trafficEmergency() {
        isEmergency = true
    }

    fun resetEmergency() {
        isEmergency = false
    }

    fun report() = "Xavfsizlik: $cameraCount ta kamera, favqulodda holat ${if (isEmergency) "faol" else "faol emas"}"
}
