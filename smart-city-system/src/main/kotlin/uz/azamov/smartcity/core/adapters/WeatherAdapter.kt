package uz.azamov.smartcity.core.adapters

class WeatherAdapter(
    private val externalApi: ExternalWeatherApi = ExternalWeatherApi()
) : WeatherService {

    override fun getCurrentWeather(): WeatherInfo {
        val raw = externalApi.fetchRawWeatherData()
        val temperatureFahrenheit = raw["tempF"] as Double
        val condition = raw["condition"] as String
        val temperatureCelsius = (temperatureFahrenheit - 32) / 1.8

        val description = when (condition) {
            "RAIN" -> "Yomg'ir yog'moqda"
            "STORM" -> "Bo'ron, ehtiyot choralarini ko'ring"
            "FOG" -> "Tuman, ko'rinish past"
            else -> "Ochiq, quyoshli havo"
        }

        return WeatherInfo(temperatureCelsius, condition, description)
    }
}