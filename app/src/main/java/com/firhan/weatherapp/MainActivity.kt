package com.firhan.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.firhan.weatherapp.presentation.ui.WeatherScreen
import com.firhan.weatherapp.presentation.viewmodel.WeatherViewModel
import com.firhan.weatherapp.ui.theme.WeatherAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel: WeatherViewModel = hiltViewModel()

                    // Collect State
                    val state by viewModel.state.collectAsStateWithLifecycle()

                    WeatherScreen(
                        state = state,
                        onRetry = {
                            viewModel.fetchWeather("Ciparay")
                        }
                    )
                }
            }
        }
    }
}