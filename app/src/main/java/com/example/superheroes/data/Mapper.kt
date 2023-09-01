package com.example.superheroes.data

import com.example.superheroes.data.local.SuperheroEntity
import com.example.superheroes.data.remote.Superhero

fun Superhero.convertToEntity(): SuperheroEntity =
    SuperheroEntity(
        this.id,
        this.nombre,
        this.origen,
        this.imagen,
        this.poder,
        this.aniocreacion
    )