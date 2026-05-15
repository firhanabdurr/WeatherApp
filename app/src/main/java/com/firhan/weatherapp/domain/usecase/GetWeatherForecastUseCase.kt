package com.firhan.weatherapp.domain.usecase

import com.firhan.weatherapp.core.util.Resource
import com.firhan.weatherapp.domain.model.WeatherInfo
import com.firhan.weatherapp.domain.repository.WeatherRepository
import javax.inject.Inject

class GetWeatherForecastUseCase @Inject constructor(
    private val repository: WeatherRepository
) { suspend operator fun invoke(areaId: String): Resource<WeatherInfo> {
        if (areaId.isBlank()) {
            return Resource.Error("Kode lokasi tidak boleh kosong")
        }
        return repository.getWeatherForecast(areaId)
    }
}