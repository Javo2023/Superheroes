package com.example.superheroes.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface SuperheroApi {
    @GET("superheroes/")
    suspend fun getData(): Response<List<Superhero>>

}