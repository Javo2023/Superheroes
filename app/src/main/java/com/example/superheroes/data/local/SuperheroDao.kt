package com.example.superheroes.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.superheroes.data.remote.SuperheroDetail

@Dao
interface SuperheroDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSuperhero(superheroEntity: List<SuperheroEntity>)

    @Query("Select * from tabla_superheroes order by id asc")
    fun getSuperheroes(): LiveData<List<SuperheroEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetailSuperhero(superheroEntity:SuperheroDetailEntity)

    @Query("Select * from tabla_detalle_superheroes where id = :id")
    fun getDetailSuperhero(id:String):LiveData<SuperheroDetailEntity>
}