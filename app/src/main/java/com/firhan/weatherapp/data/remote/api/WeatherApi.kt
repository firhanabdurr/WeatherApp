package com.firhan.weatherapp.data.remote.api

import com.firhan.weatherapp.data.remote.dto.WeatherResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("api/weather/forecast")
    suspend fun getForecast(
        @Query("area") areaId: String // Query parameter lokasi
    ): WeatherResponseDto
}