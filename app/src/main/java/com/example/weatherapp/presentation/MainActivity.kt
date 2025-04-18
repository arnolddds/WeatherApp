package com.example.weatherapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import com.arkivanov.decompose.defaultComponentContext
import com.example.weatherapp.WeatherApplication
import com.example.weatherapp.presentation.root.DefaultRootComponent
import com.example.weatherapp.presentation.root.RootContent
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var rootComponentFactory: DefaultRootComponent.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as WeatherApplication).applicationComponent.inject(activity = this)
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        val root = rootComponentFactory.create(defaultComponentContext())
        setContent {
            RootContent(
                component = root
            )
        }
    }
}
