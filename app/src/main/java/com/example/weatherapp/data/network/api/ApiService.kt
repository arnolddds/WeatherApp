package com.example.weatherapp.data.network.api

import com.example.weatherapp.data.network.dto.CityDto
import com.example.weatherapp.data.network.dto.WeatherCurrentDto
import com.example.weatherapp.data.network.dto.WeatherForecastDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("current.json?key=c51551529c05460d88e63455251104")
    suspend fun loadCurrentWeather(
        @Query("q") query: String
    ): WeatherCurrentDto

    @GET("forecast.json?key=c51551529c05460d88e63455251104")
    suspend fun loadForecast(
        @Query("q") query: String,
        @Query("days") daysCount: Int = 4
    ): WeatherForecastDto

    @GET("search.json?key=c51551529c05460d88e63455251104")
    suspend fun searchCity(
        @Query("q") query: String
    ): List<CityDto>
}