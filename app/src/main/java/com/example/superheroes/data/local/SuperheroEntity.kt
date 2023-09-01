package com.example.superheroes.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "tabla_superheroes")
data class SuperheroEntity(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    val nombre: String,
    val origen: String,
    @SerializedName("imagenLink") val imagen: String,
    val poder: String,
    @SerializedName("Año_creacion") val aniocreacion: Int
)
