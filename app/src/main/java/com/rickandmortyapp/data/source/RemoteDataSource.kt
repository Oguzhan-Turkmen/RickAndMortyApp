package com.rickandmortyapp.data.source

import com.rickandmortyapp.data.NetworkResponseState
import com.rickandmortyapp.data.dto.Character

interface RemoteDataSource {
    suspend fun getCharacters(): NetworkResponseState<List<Character>>
}