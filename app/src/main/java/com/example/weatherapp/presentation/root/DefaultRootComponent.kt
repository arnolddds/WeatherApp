package com.example.weatherapp.presentation.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.example.weatherapp.domain.entity.City
import com.example.weatherapp.presentation.detail.DefaultDetailsComponent
import com.example.weatherapp.presentation.favourite.DefaultFavouriteComponent
import com.example.weatherapp.presentation.search.DefaultSearchComponent
import com.example.weatherapp.presentation.search.OpenReason
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.parcelize.Parcelize
import javax.inject.Inject

class DefaultRootComponent @AssistedInject constructor(
    private val detailsComponentFactory: DefaultDetailsComponent.Factory,
    private val searchComponentFactory: DefaultSearchComponent.Factory,
    private val favouriteComponentFactory: DefaultFavouriteComponent.Factory,
    @Assisted("componentContext") componentContext: ComponentContext
) : RootComponent, ComponentContext by componentContext {
    override val stack: Value<ChildStack<*, RootComponent.Child>>
        get() = TODO("Not yet implemented")

    private fun child(
        config: Config,
        componentContext: ComponentContext
    ): RootComponent.Child {
        return when (config) {
            is Config.Details -> {
                val component = detailsComponentFactory.create(
                    city = config.city,
                    onBackClicked = {

                    },
                    componentContext = componentContext
                )
                RootComponent.Child.Details(component = component)
            }

            Config.Favourite -> {
                val component = favouriteComponentFactory.create(
                    onCityItemClicked = {

                    },
                    onAddFavouriteClick = {

                    },
                    onSearchClicked = {

                    },
                    componentContext = componentContext
                )
                RootComponent.Child.Favourite(component = component)
            }

            is Config.Search -> {
                val component = searchComponentFactory.create(
                    openReason = config.openReason,
                    onBackClick = {

                    },
                    onCitySavedToFavouriteClicked = {

                    },
                    onForecastForCityRequested = {

                    },
                    componentContext = componentContext
                )
                RootComponent.Child.Search(component = component)
            }
        }
    }

    sealed interface Config : Parcelable {
        @Parcelize
        data object Favourite : Config

        @Parcelize
        data class Search(val openReason: OpenReason) : Config

        @Parcelize
        data class Details(val city: City) : Config
    }

    @AssistedFactory
    interface Factory {
        fun create(
            @Assisted("componentContext") componentContext: ComponentContext
        ):DefaultRootComponent
    }
}

