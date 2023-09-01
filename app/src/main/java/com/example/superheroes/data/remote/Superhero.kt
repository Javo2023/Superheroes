package com.example.superheroes.data.remote

import com.google.gson.annotations.SerializedName

data class Superhero(
    val id: Int,
    val nombre: String,
    val origen: String,
    @SerializedName ("imagenLink") val imagen: String,
    val poder: String,
    @SerializedName("año_creación") val aniocreacion : Long
)
