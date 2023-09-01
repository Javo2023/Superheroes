package com.example.superheroes.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.superheroes.data.local.SuperheroDao
import com.example.superheroes.data.local.SuperheroEntity
import com.example.superheroes.data.remote.Superhero
import com.example.superheroes.data.remote.SuperheroApi

class Repository (private val superheroApi: SuperheroApi, private val superheroDao: SuperheroDao){

    fun getSuperheroesEntity(): LiveData<List<SuperheroEntity>> = superheroDao.getSuperheroes()

    suspend fun loadSuperheroes(){
        val response = superheroApi.getData()
        if (response.isSuccessful) {
            val resp = response.body()

            resp?.let{
                val superheroEntity = it.map{it.convertToEntity()}
                superheroDao.insertSuperhero(superheroEntity)
            }
        }else{
            Log.e("repositorio", response.errorBody().toString())
        }

    }


}

fun Superhero.convertToEntity(): SuperheroEntity = SuperheroEntity(this.id,this.nombre,this.origen,this.imagen,this.poder,this.aniocreacion)

