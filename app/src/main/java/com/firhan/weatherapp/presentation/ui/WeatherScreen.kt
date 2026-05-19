package com.firhan.weatherapp.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.firhan.weatherapp.presentation.components.WeatherCard
import com.firhan.weatherapp.presentation.state.WeatherUiState

@Composable
fun WeatherScreen(
    state: WeatherUiState,
    onRetry: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when (state) {
            is WeatherUiState.Loading -> {
                CircularProgressIndicator()
            }
            is WeatherUiState.Error -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = state.message,
                        color = MaterialTheme.colorScheme.error,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = onRetry) {
                        Text("Coba Lagi")
                    }
                }
            }
            is WeatherUiState.Success -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    WeatherCard(weatherInfo = state.data)

                    // TODO: Nanti bisa ditambahin LazyRow/LazyColumn buat nampilin
                    // state.data.forecasts (List perkiraan cuaca ke depannya)
                }
            }
        }
    }
}