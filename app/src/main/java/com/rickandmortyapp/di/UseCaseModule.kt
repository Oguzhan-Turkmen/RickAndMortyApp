package com.rickandmortyapp.di

import com.rickandmortyapp.domain.GetCharactersUseCase
import com.rickandmortyapp.domain.GetCharactersUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    @ViewModelScoped
    abstract fun bindGetCharacterUseCase(getCharactersUseCaseImpl: GetCharactersUseCaseImpl):GetCharactersUseCase

}