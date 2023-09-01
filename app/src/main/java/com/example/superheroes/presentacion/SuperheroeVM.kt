package com.example.superheroes.presentacion

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.superheroes.data.Repositorio
import com.example.superheroes.data.local.SuperheroeDatabase
import com.example.superheroes.data.remote.SuperheroeRetrofit
import kotlinx.coroutines.launch

class SuperheroeVM (application: Application):AndroidViewModel(application){
    private val repositorio : Repositorio

    fun superheroeLiveData()=repositorio.obtenerSuperheroesEntity()


    init{
        val api = SuperheroeRetrofit.obtenerRetrofitSuperheroe()
        val superheroeDatabase = SuperheroeDatabase.obtenerDataBase(application).obtenerSuperheroesDao()
        repositorio=Repositorio(api,superheroeDatabase)
    }
    fun obtenerSuperheroes() = viewModelScope.launch{
        repositorio.cargarSuperheroes()
    }



}