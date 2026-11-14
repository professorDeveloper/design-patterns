package uz.azamov.smartcity.core.adapters

class WeatherAdapter(
    private val externalApi: ExternalWeatherApi = ExternalWeatherApi()
) : WeatherService {

    override fun getCurrentWeather(): Weather {
        val raw = externalApi.fetchRawWeatherData()
        val fahrenheit = raw["tempF"] as Double
        val condition = WeatherCondition.valueOf(raw["condition"] as String)
        return Weather((fahrenheit - 32) / 1.8, condition)
    }
}
