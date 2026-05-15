package com.firhan.weatherapp.domain.model

// Data utama cuaca saat ini beserta list perkiraan ke depannya
data class WeatherInfo(
    val locationName: String,
    val currentTemperature: Double,
    val currentCondition: String, // Misal: "Cerah", "Hujan Ringan"
    val currentHumidity: Int,
    val windSpeed: Double,
    val forecasts: List<WeatherForecast>
)

// Data untuk list per jam / per hari di baris bawah UI
data class WeatherForecast(
    val time: String, // Jam atau Tanggal
    val temperature: Double,
    val condition: String,
    val iconCode: String // Nanti dipake buat milih icon (Cerah, Hujan, Petir)
)