package com.rickandmortyapp.domain

import com.rickandmortyapp.data.NetworkResponseState
import kotlinx.coroutines.flow.Flow

interface GetCharactersUseCase {

    operator fun invoke(): Flow<NetworkResponseState<List<CharacterEntity>>>
}