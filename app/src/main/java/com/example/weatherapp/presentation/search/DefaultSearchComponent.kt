package com.example.weatherapp.presentation.search

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import com.example.weatherapp.domain.entity.City
import com.example.weatherapp.presentation.extensions.componentScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class DefaultSearchComponent @Inject constructor(
    private val storeFactory: SearchStoreFactory,
    private val openReason: OpenReason,
    private val onBackClick: () -> Unit,
    private val onCitySavedToFavouriteClicked: () -> Unit,
    private val onForecastForCityRequested: (City) -> Unit,
    componentContext: ComponentContext
) : SearchComponent, ComponentContext by componentContext {

    private val store = instanceKeeper.getStore { storeFactory.create(openReason) }
    private val scope = componentScope()

    init {
        scope.launch {
            store.labels.collect {
                when (it) {
                    SearchStore.Label.ClickBack -> {
                        onBackClick()
                    }

                    is SearchStore.Label.OpenForecast -> {
                        onForecastForCityRequested(it.city)
                    }

                    SearchStore.Label.SavedToFavourite -> {
                        onCitySavedToFavouriteClicked()
                    }
                }
            }
        }
    }

    override fun changeQueryStatus(query: String) {
        store.accept(SearchStore.Intent.ChangeSearchQuery(query))
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override val model: StateFlow<SearchStore.State> = store.stateFlow

    override fun onClickBack() {
        store.accept(SearchStore.Intent.ClickBack)
    }

    override fun onClickSearch() {
        store.accept(SearchStore.Intent.ClickSearch)
    }

    override fun onClickCity(city: City) {
        store.accept(SearchStore.Intent.ClickCity(city))

    }
}