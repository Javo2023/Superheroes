package com.example.superheroes.data.remote

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class SuperheroDetail(
    @PrimaryKey val id:Int,
    val nombre: String,
    val origen: String,
    @SerializedName("imagenLink") val imagen: String,
    val poder : String,
    @SerializedName("año_creacion") val aniocreacion:Int,
    val color: String,
    val traduccion: Boolean
)
