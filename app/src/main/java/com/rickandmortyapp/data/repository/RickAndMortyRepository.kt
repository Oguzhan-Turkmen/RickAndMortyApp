package com.rickandmortyapp.data.repository

import com.rickandmortyapp.data.NetworkResponseState
import com.rickandmortyapp.data.dto.Character

interface RickAndMortyRepository {
    suspend fun getCharacters(): NetworkResponseState<List<Character>>
}