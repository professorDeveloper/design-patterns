package uz.azamov.smartcity.core.adapters

class ExternalWeatherApi {
    fun fetchRawWeatherData(): Map<String, Any> = mapOf(
        "tempF" to (41..95).random().toDouble(),
        "condition" to listOf("CLEAR", "RAIN", "STORM", "FOG").random()
    )
}
