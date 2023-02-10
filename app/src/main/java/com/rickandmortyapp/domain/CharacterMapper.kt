package com.rickandmortyapp.domain

interface CharacterMapper<I, O> {
    fun map(input: I?): O
}