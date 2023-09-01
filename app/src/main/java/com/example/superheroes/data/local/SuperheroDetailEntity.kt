package com.example.superheroes.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName="tabla_detalle_superheroes")
data class SuperheroDetailEntity(
    @PrimaryKey val id:Long,
    val nombre: String,
    val origen: String,
    @SerializedName("imagenLink") val imagen: String,
    val poder : String,
    @SerializedName("Año_creacion") val aniocreacion:Long,
    val color: String,
    val traduccion: Boolean

)
