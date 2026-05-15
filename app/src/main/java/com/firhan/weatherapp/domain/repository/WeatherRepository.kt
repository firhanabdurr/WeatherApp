package com.firhan.weatherapp.domain.repository
import com.firhan.weatherapp.core.util.Resource
import com.firhan.weatherapp.domain.model.WeatherInfo

interface WeatherRepository {
    // Parameter areaId ini nanti menyesuaikan
    suspend fun getWeatherForecast(areaId: String): Resource<WeatherInfo>
}