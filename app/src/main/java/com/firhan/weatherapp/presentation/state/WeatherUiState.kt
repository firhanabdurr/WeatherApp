package com.firhan.weatherapp.presentation.state

import com.firhan.weatherapp.domain.model.WeatherInfo

sealed interface WeatherUiState {
    object Loading : WeatherUiState
    data class Success(val data: WeatherInfo) : WeatherUiState
    data class Error(val message: String) : WeatherUiState
}