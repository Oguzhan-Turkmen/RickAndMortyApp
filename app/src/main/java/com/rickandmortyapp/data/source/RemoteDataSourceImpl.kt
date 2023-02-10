package com.rickandmortyapp.data.source

import com.rickandmortyapp.data.NetworkResponseState
import com.rickandmortyapp.data.api.RickAndMortyApi
import com.rickandmortyapp.data.dto.Character
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val rickAndMortyApi: RickAndMortyApi
) : RemoteDataSource {

    override suspend fun getCharacters(): NetworkResponseState<List<Character>> =
        try {
            val response = rickAndMortyApi.getCharacters()
            NetworkResponseState.Success(response.results)
        } catch (e: Exception) {
            NetworkResponseState.Error(e)
        }
}


