package com.rickandmortyapp.data.repository

import com.rickandmortyapp.data.NetworkResponseState
import com.rickandmortyapp.data.dto.Character
import com.rickandmortyapp.data.source.RemoteDataSource
import com.rickandmortyapp.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import java.lang.Exception

class RickAndMortyRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : RickAndMortyRepository {

    override suspend fun getCharacters(): NetworkResponseState<List<Character>> =
        withContext(ioDispatcher) {
            try {
                remoteDataSource.getCharacters()
            } catch (e: Exception) {
                NetworkResponseState.Error(e)
            }
        }
}