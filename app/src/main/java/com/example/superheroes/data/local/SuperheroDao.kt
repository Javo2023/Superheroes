package com.example.superheroes.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SuperheroDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSuperhero(SuperheroEntity: List<SuperheroEntity>)

    @Query("Select* from tabla_superheroes order by id asc")
    fun getSuperheroes(): LiveData<List<SuperheroEntity>>
}