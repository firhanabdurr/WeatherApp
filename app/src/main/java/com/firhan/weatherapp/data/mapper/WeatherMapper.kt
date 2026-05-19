package com.firhan.weatherapp.data.mapper

import com.firhan.weatherapp.data.remote.dto.WeatherResponseDto
import com.firhan.weatherapp.domain.model.WeatherForecast
import com.firhan.weatherapp.domain.model.WeatherInfo

fun WeatherResponseDto.toDomain(): WeatherInfo {
    val areaData = this.data
    val locationName = areaData?.description ?: "Lokasi Tidak Diketahui"

    // Logic placeholder untuk ngekstrak suhu dan cuaca dari array
    var currentTemp = 0.0
    var currentCondition = "Cerah"
    var currentHumidity = 0
    val forecastList = mutableListOf<WeatherForecast>()

    areaData?.params?.forEach { param ->
        when (param.id) {
            "t" -> currentTemp = param.times?.firstOrNull()?.value?.toDoubleOrNull() ?: 0.0
            "hu" -> currentHumidity = param.times?.firstOrNull()?.value?.toIntOrNull() ?: 0
            "weather" -> currentCondition = param.times?.firstOrNull()?.value ?: "Cerah"
        }
    }

    return WeatherInfo(
        locationName = locationName,
        currentTemperature = currentTemp,
        currentCondition = currentCondition,
        currentHumidity = currentHumidity,
        windSpeed = 0.0,
        forecasts = forecastList // Mapping list times dari DTO ke WeatherForecast
    )
}