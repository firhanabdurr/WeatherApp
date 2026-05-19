package com.firhan.weatherapp.data.remote.dto
import com.google.gson.annotations.SerializedName

data class WeatherResponseDto(
    @SerializedName("success") val success: Boolean,
    @SerializedName("message") val message: String?,
    @SerializedName("data") val data: AreaWeatherDto?
)

data class AreaWeatherDto(
    @SerializedName("domain") val domain: String?,
    @SerializedName("description") val description: String?, // Nama kota/lokasi
    @SerializedName("params") val params: List<WeatherParamDto>?
)

data class WeatherParamDto(
    @SerializedName("id") val id: String?, // "t" untuk temperature, "hu" untuk humidity
    @SerializedName("description") val description: String?,
    @SerializedName("times") val times: List<WeatherTimeDto>?
)

data class WeatherTimeDto(
    @SerializedName("datetime") val datetime: String?,
    @SerializedName("value") val value: String?
)