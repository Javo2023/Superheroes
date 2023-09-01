package com.example.superheroes.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SuperheroeEntity::class],version = 1)
abstract class SuperheroeDatabase: RoomDatabase() {

    abstract fun obtenerSuperheroesDao(): SuperheroeDao

    companion object {
        @Volatile
        private var INSTANCE: SuperheroeDatabase? = null

        fun obtenerDataBase(context: Context): SuperheroeDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SuperheroeDatabase::class.java,
                    "razas_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }



}