package com.example.superheroes.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_superheroes")
data class SuperheroeEntity(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    val nombre: String,
    val origen: String,
    val imagenLink: String,
    val poder: String,
    val año_creación: Long
)
