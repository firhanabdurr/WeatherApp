package com.firhan.weatherapp.data.repository

import com.firhan.weatherapp.core.util.Resource
import com.firhan.weatherapp.data.mapper.toDomain
import com.firhan.weatherapp.data.remote.api.WeatherApi
import com.firhan.weatherapp.domain.model.WeatherInfo
import com.firhan.weatherapp.domain.repository.WeatherRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {

    override suspend fun getWeatherForecast(areaId: String): Resource<WeatherInfo> {
        return try {
            // 1. Tembak API
            val response = api.getForecast(areaId)

            // 2. Mapping DTO ke Domain Model lalu bungkus ke Resource.Success
            Resource.Success(response.toDomain())
        } catch (e: IOException) {
            // Error jaringan (gak ada internet, dll)
            Resource.Error("NO INTERNET")
        } catch (e: HttpException) {
            // Error dari server (404, 500, dll)
            Resource.Error("SERVER ERROR (Code: ${e.code()}).")
        } catch (e: Exception) {
            // Error tak terduga lainnya
            Resource.Error("ERROR: ${e.localizedMessage}")
        }
    }
}