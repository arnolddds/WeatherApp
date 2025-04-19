package com.example.weatherapp.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.weatherapp.data.local.model.CityDbModel


@Database(entities = [CityDbModel::class], version = 1, exportSchema = false)
abstract class FavouriteDataBase:RoomDatabase() {

    abstract fun favouriteCitiesDao(): FavouriteCitiesDao

    companion object {
        private const val DB_NAME = "FavouriteDataBase"
        private var INSTANCE: FavouriteDataBase? = null
        private val LOCK = Any()

        fun getInstance(context: Context): FavouriteDataBase {
            INSTANCE?.let { return it }

            synchronized(LOCK) {
                INSTANCE?.let { return it }
                val dataBase = Room.databaseBuilder(
                    context = context,
                    klass = FavouriteDataBase::class.java,
                    name = DB_NAME
                ).build()
                INSTANCE = dataBase
                return dataBase
            }
        }
    }
}