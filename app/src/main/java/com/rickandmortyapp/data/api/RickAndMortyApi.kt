package com.rickandmortyapp.data.api

import com.rickandmortyapp.data.dto.CharacterResponse
import retrofit2.http.GET

interface RickAndMortyApi {

    @GET(ALL_CHARECTER_PATH)
    suspend fun getCharacters():CharacterResponse

    companion object{
       private const val ALL_CHARECTER_PATH = "character"
    }

}