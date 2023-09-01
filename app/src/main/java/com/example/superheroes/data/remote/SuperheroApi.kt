package com.example.superheroes.data.remote

import com.example.superheroes.data.local.SuperheroEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SuperheroApi {
    @GET("superheroes/")
    suspend fun getData(): Response<List<Superhero>>

    @GET("superheroes/{id}")
    suspend fun getDetailSuperhero(@Path("id") id:String): Response<SuperheroDetail>

}