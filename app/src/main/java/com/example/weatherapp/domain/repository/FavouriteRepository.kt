package com.example.weatherapp.domain.repository

import com.example.weatherapp.domain.entity.City
import com.example.weatherapp.domain.entity.Weather
import kotlinx.coroutines.flow.Flow

interface FavouriteRepository {

    val favouriteCities: Flow<List<City>>

    fun observeIsFavourite(cityId: Int): Flow<Boolean>

    suspend fun addToFavourite(city: City)

    suspend fun removeFromFavourite(cityId: Int)

}