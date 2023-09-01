package com.example.superheroes.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SuperheroEntity::class, SuperheroDetailEntity::class],version = 1)
abstract class SuperheroDatabase: RoomDatabase() {

    abstract fun getSuperheroesDao(): SuperheroDao

    companion object {
        @Volatile
        private var INSTANCE: SuperheroDatabase? = null

        fun getDataBase(context: Context): SuperheroDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SuperheroDatabase::class.java,
                    "razas_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }



}