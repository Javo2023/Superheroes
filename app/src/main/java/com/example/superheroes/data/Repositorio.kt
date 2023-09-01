package com.example.superheroes.data

import androidx.lifecycle.LiveData
import com.example.superheroes.data.local.SuperheroeDao
import com.example.superheroes.data.local.SuperheroeEntity
import com.example.superheroes.data.remote.Superheroe
import com.example.superheroes.data.remote.SuperheroeApi

class Repositorio (private val superheroeApi: SuperheroeApi, private val superheroeDao: SuperheroeDao){

    fun obtenerSuperheroesEntity(): LiveData<List<SuperheroeEntity>> = superheroeDao.obtenerSuperheroes()

    suspend fun cargarSuperheroes(){
        val respuesta = superheroeApi.obtenerDatos()
        if (respuesta.isSuccessful) {
            val resp = respuesta.body()

            resp?.let{
                val superheroeEntity = it.map{it.convertToEntity()}
                superheroeDao.insertarSuperheroe(superheroeEntity)
            }
        }
    }


}

fun Superheroe.convertToEntity(): SuperheroeEntity = SuperheroeEntity(this.id,this.nombre,this.origen,this.imagenLink,this.poder,this.año_creación)

