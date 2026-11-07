package uz.azamov.smartcity.core.adapters

interface WeatherService {
    fun getCurrentWeather(): WeatherInfo
}

data class WeatherInfo(
    val temperatureCelsius: Double,
    val condition: String,
    val description: String
)
