package com.example.superheroes.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SuperheroeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarSuperheroe(SuperheroeEntity: List<SuperheroeEntity>)

    @Query("Select* from tabla_superheroes order by id asc")
    fun obtenerSuperheroes(): LiveData<List<SuperheroeEntity>>
}