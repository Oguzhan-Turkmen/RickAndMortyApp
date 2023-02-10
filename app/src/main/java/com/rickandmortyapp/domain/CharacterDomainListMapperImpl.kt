package com.rickandmortyapp.domain

import javax.inject.Inject
import com.rickandmortyapp.data.dto.Character

class CharacterDomainListMapperImpl @Inject constructor() :
    CharacterListMapper<Character, CharacterEntity> {
    override fun map(input: List<Character>?): List<CharacterEntity> {
        return input?.map {
            CharacterEntity(
                id = it.id,
                name = it.name,
                image = it.image,
                status = it.status,
                species = it.species
            )
        } ?: emptyList()
    }

}