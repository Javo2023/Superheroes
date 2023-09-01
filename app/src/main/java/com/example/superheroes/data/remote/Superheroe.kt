package com.example.superheroes.data.remote

data class Superheroe(
    val id: Long,
    val nombre: String,
    val origen: String,
    val imagenLink: String,
    val poder: String,
    val año_creación: Long
)
