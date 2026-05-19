package com.firhan.weatherapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.firhan.weatherapp.core.util.Resource
import com.firhan.weatherapp.domain.usecase.GetWeatherForecastUseCase
import com.firhan.weatherapp.presentation.state.WeatherUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeatherForecastUseCase: GetWeatherForecastUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<WeatherUiState>(WeatherUiState.Loading)
    val state = _state.asStateFlow()

    init {
        fetchWeather("Ciparay")
    }

    fun fetchWeather(areaId: String) {
        viewModelScope.launch {
            _state.value = WeatherUiState.Loading

            when (val result = getWeatherForecastUseCase(areaId)) {
                is Resource.Success -> {
                    // force unwrapping data
                    _state.value = WeatherUiState.Success(result.data!!)
                }
                is Resource.Error -> {
                    _state.value = WeatherUiState.Error(result.message ?: "Terjadi kesalahan tak terduga")
                }
            }
        }
    }
}