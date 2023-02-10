package com.rickandmortyapp.ui.home

import com.rickandmortyapp.domain.CharacterEntity
import com.rickandmortyapp.domain.CharacterListMapper
import javax.inject.Inject

class CharacterUiMapperImpl @Inject constructor() : CharacterListMapper<CharacterEntity, HomeUiData> {
    override fun map(input: List<CharacterEntity>?): List<HomeUiData> {
        return input?.map {
            HomeUiData(
                name = it.name,
                image = it.image,
                status = it.status
            )
        } ?: emptyList()
    }
}