package uz.azamov.smartcity.core.adapters

class ExternalWeatherApi {

    fun fetchRawWeatherData(): Map<String, Any> {
        val conditions = listOf("CLEAR", "RAIN", "STORM", "FOG")
        val temperatureFahrenheit = (41..95).random().toDouble()
        val condition = conditions.random()
        return mapOf(
            "tempF" to temperatureFahrenheit,
            "condition" to condition
        )
    }
}
