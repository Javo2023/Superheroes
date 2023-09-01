package com.example.superheroes.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SuperheroeRetrofit {
    companion object {
        private const val URL_BASE = "https://y-mariocanedo.vercel.app/"
        fun getRetrofitSuperheroe(): SuperheroeApi {

            val mRetrofit = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return mRetrofit.create(SuperheroeApi::class.java)

        }
    }
}