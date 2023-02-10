package com.rickandmortyapp.di

import com.rickandmortyapp.domain.CharacterDomainListMapperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import com.rickandmortyapp.data.dto.Character
import com.rickandmortyapp.domain.CharacterEntity
import com.rickandmortyapp.domain.CharacterListMapper
import com.rickandmortyapp.ui.home.HomeUiData
import com.rickandmortyapp.ui.home.CharacterUiMapperImpl

@Module
@InstallIn(ViewModelComponent::class)
abstract class CharacterMapperModule {

    @Binds
    @ViewModelScoped
    abstract fun bindCharacterDomainListMapper(characterDomainListMapperImpl: CharacterDomainListMapperImpl): CharacterListMapper<Character, CharacterEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindHomeUiMapper(homeUiMapperImpl: CharacterUiMapperImpl): CharacterListMapper<CharacterEntity, HomeUiData>
}