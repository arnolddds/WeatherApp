package com.example.weatherapp.data.network.dto

import com.google.gson.annotations.SerializedName

data class DayWeatherDto(
    @SerializedName("avgtemp_c") val tempC: Long,
    @SerializedName("condition") val conditionDto: ConditionDto,
)