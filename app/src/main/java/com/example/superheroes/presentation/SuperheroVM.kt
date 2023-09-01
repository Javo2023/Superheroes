package com.example.superheroes.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.superheroes.data.Repository
import com.example.superheroes.data.local.SuperheroDatabase
import com.example.superheroes.data.remote.SuperheroRetrofit
import kotlinx.coroutines.launch

class SuperheroVM (application: Application):AndroidViewModel(application){
    private val repository : Repository

    fun superheroLiveData()=repository.getSuperheroesEntity()

    fun detailLiveData(id:String)=repository.getDetailEntity(id)


    init{
        val api = SuperheroRetrofit.getRetrofitSuperhero()
        val superheroDatabase = SuperheroDatabase.getDataBase(application).getSuperheroesDao()
        repository=Repository(api,superheroDatabase)
    }
    fun getAllSuperheroes() = viewModelScope.launch{
        repository.loadSuperheroes()
    }

    fun getDetailSuperheroVM(id:String)=viewModelScope.launch {
        repository.getDetailSuperhero(id)
    }



}