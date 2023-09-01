package com.example.superheroes.data

import androidx.lifecycle.LiveData
import com.example.superheroes.data.local.SuperheroDao
import com.example.superheroes.data.local.SuperheroEntity
import com.example.superheroes.data.remote.Superhero
import com.example.superheroes.data.remote.SuperheroApi

class Repository (private val superheroApi: SuperheroApi, private val superheroDao: SuperheroDao){

    fun obtenerSuperheroesEntity(): LiveData<List<SuperheroEntity>> = superheroDao.getSuperheroes()

    suspend fun cargarSuperheroes(){
        val respuesta = superheroApi.getData()
        if (respuesta.isSuccessful) {
            val resp = respuesta.body()

            resp?.let{
                val superheroeEntity = it.map{it.convertToEntity()}
                superheroDao.insertSuperhero(superheroeEntity)
            }
        }
    }


}

fun Superhero.convertToEntity(): SuperheroEntity = SuperheroEntity(this.id,this.nombre,this.origen,this.imagenLink,this.poder,this.aniocreacion)

