package com.example.superheroes.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface SuperheroeApi {
    @GET("superheroes/")
    suspend fun getData(): Response<List<Superheroe>>

}