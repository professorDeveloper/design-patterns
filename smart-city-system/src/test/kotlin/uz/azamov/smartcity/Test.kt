package uz.azamov.smartcity

import uz.azamov.smartcity.core.facade.SmartCityFacade
import uz.azamov.smartcity.core.adapters.Weather
import uz.azamov.smartcity.core.adapters.WeatherCondition
import uz.azamov.smartcity.core.adapters.WeatherService
import uz.azamov.smartcity.core.builders.SmartStreet
import uz.azamov.smartcity.core.proxy.SecurityProxy
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Test {
    private var condition = WeatherCondition.CLEAR
    private val facade = SmartCityFacade(object : WeatherService {
        override fun getCurrentWeather() = Weather(20.0, condition)
    })

    @Test
    fun `builder creates devices through factory`() {
        val street = SmartStreet.Builder("Bobur").addLights(3).addCameras(2).addTrafficLight().addTrafficLight().build()

        assertEquals(3, street.lightsCount)
        assertEquals(2, street.camerasCount)
        assertEquals(6, street.devices.size)
    }

    @Test
    fun `new street updates city subsystems`() {
        facade.buildStreet("Chilonzor", lights = 4, cameras = 2, withTrafficLight = true)

        assertEquals(4, facade.lighting.lampCount)
        assertEquals(2, facade.security.cameraCount)
        assertEquals(1, facade.transport.trafficLightCount)
    }

    @Test
    fun `proxy blocks wrong access code`() {
        facade.activateEmergency("xato")
        assertFalse(facade.lighting.isOn)

        facade.activateEmergency(SecurityProxy.ACCESS_CODE)
        assertEquals(100, facade.lighting.brightness)
    }

    @Test
    fun `eco mode turns lights off and back on`() {
        facade.setEcoMode(true)
        assertTrue(facade.energy.isEcoMode)
        assertFalse(facade.lighting.isOn)
        assertEquals(50.0, facade.energy.consume(100.0))

        facade.setEcoMode(false)
        assertEquals(100, facade.lighting.brightness)
    }

    @Test
    fun `weather controls lighting`() {
        condition = WeatherCondition.STORM
        facade.connectToWeatherService()
        assertEquals(100, facade.lighting.brightness)

        condition = WeatherCondition.CLEAR
        facade.connectToWeatherService()
        assertEquals(50, facade.lighting.brightness)
    }
}
