package com.firhan.weatherapp.presentation.components

import androidx.compose.runtime.Composable

@Composable
fun WeatherCard(
    weatherInfo: WeatherInfo,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = weatherInfo.locationName,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "${weatherInfo.currentTemperature}°C",
                fontSize = 64.sp,
                fontWeight = FontWeight.Light
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = weatherInfo.currentCondition,
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
            )
            Spacer(modifier = Modifier.height(32.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Kelembapan", fontWeight = FontWeight.SemiBold)
                    Text("${weatherInfo.currentHumidity}%")
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Angin", fontWeight = FontWeight.SemiBold)
                    Text("${weatherInfo.windSpeed} km/h")
                }
            }
        }
    }
}