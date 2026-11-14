package uz.azamov.smartcity.core.adapters

interface WeatherService {
    fun getCurrentWeather(): Weather
}

data class Weather(val temperatureCelsius: Double, val condition: WeatherCondition)

enum class WeatherCondition(val description: String, val isBad: Boolean) {
    CLEAR("Ochiq, quyoshli havo", false),
    RAIN("Yomg'ir yog'moqda", true),
    STORM("Bo'ron, ehtiyot choralarini ko'ring", true),
    FOG("Tuman, ko'rinish past", true)
}
