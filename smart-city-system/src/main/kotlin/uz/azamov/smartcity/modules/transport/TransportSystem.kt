package uz.azamov.smartcity.modules.transport

enum class TrafficLevel(val title: String, val greenLightSeconds: Int) {
    LOW("past", 20),
    NORMAL("normal", 30),
    HIGH("yuqori", 60)
}

class TransportSystem {
    var trafficLevel = TrafficLevel.NORMAL
        private set
    var trafficLightCount = 0
        private set

    fun updateTrafficLevel(level: TrafficLevel) {
        trafficLevel = level
    }

    fun addTrafficLight() {
        trafficLightCount++
    }

    fun report() = "Transport: tirbandlik ${trafficLevel.title}, yashil chiroq ${trafficLevel.greenLightSeconds} soniya, " +
        "svetaforlar $trafficLightCount ta"
}
