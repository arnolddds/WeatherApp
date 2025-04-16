package com.example.weatherapp.presentation.detail

import com.example.weatherapp.presentation.favourite.FavouriteStore
import kotlinx.coroutines.flow.StateFlow

interface DetailsComponent {
    val model: StateFlow<DetailsStore.State>

    fun onBackClick()

    fun onClickChangeFavouriteStatus()
}