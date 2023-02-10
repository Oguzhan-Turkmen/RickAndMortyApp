package com.rickandmortyapp.domain

import com.rickandmortyapp.data.NetworkResponseState
import com.rickandmortyapp.data.repository.RickAndMortyRepository
import com.rickandmortyapp.data.dto.Character
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCharactersUseCaseImpl @Inject constructor(
    private val rickAndMortyRepository: RickAndMortyRepository,
    private val characterListMapper: CharacterListMapper<Character, CharacterEntity>
) : GetCharactersUseCase {

    override fun invoke(): Flow<NetworkResponseState<List<CharacterEntity>>> =
        flow {
            emit(NetworkResponseState.Loading)
            when (val response = rickAndMortyRepository.getCharacters()) {
                is NetworkResponseState.Error -> emit(response)
                NetworkResponseState.Loading -> Unit
                is NetworkResponseState.Success -> emit(
                    NetworkResponseState.Success(
                        characterListMapper.map(
                            response.result
                        )
                    )
                )
            }
        }
}
