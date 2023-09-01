package com.example.superheroes.data

import com.example.superheroes.data.remote.Superhero
import org.junit.Assert.*

import org.junit.Test

class MapperTest {

    @Test
    fun convertToEntity() {
        //given
        val superhero = Superhero(1,"name","tierra","imagen","ninguno",1982)
        //when
        val result = superhero.convertToEntity()

        //then
        assertEquals(superhero.id,result.id)
        assertEquals(superhero.nombre,result.nombre)
        assertEquals(superhero.origen,result.origen)
        assertEquals(superhero.imagen,result.imagen)
        assertEquals(superhero.poder,result.poder)
        assertEquals(superhero.aniocreacion,result.aniocreacion)

    }
}