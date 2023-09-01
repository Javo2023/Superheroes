package com.example.superheroes.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.superheroes.data.local.SuperheroDao
import com.example.superheroes.data.local.SuperheroDetailEntity
import com.example.superheroes.data.local.SuperheroEntity
import com.example.superheroes.data.remote.Superhero
import com.example.superheroes.data.remote.SuperheroApi
import com.example.superheroes.data.remote.SuperheroDetail

class Repository(private val superheroApi: SuperheroApi, private val superheroDao: SuperheroDao) {

    fun getSuperheroesEntity(): LiveData<List<SuperheroEntity>> = superheroDao.getSuperheroes()

    fun getDetailEntity(id: String): LiveData<SuperheroDetailEntity> =
        superheroDao.getDetailSuperhero(id)

    suspend fun loadSuperheroes() {
        val response = superheroApi.getData()
        if (response.isSuccessful) {
            val resp = response.body()

            resp?.let {
                val superheroEntity = it.map { it.convertToEntity() }
                superheroDao.insertSuperhero(superheroEntity)
            }
        } else {
            Log.e("repositorio", response.errorBody().toString())
        }

    }

    suspend fun getDetailSuperhero(id: String) {
        val response = superheroApi.getDetailSuperhero(id)
        if (response.isSuccessful) {
            val detailResponse = response.body()
            detailResponse?.let {
                val superheroDetailEntity = it.convertDetailToEntity()
                superheroDao.insertDetailSuperhero(superheroDetailEntity)

            }
        }
    }


}

fun SuperheroDetail.convertDetailToEntity(): SuperheroDetailEntity = SuperheroDetailEntity(
    this.id,
    this.nombre,
    this.origen,
    this.imagen,
    this.poder,
    this.aniocreacion,
    this.color,
    this.traduccion
)



