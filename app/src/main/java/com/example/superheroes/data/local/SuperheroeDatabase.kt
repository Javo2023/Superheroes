package com.example.superheroes.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [SuperheroeEntity::class],version = 1)
abstract class SuperheroeDatabase: RoomDatabase() {

}