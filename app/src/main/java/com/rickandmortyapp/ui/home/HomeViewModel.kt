package com.rickandmortyapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rickandmortyapp.R
import com.rickandmortyapp.data.NetworkResponseState
import com.rickandmortyapp.domain.CharacterEntity
import com.rickandmortyapp.domain.CharacterListMapper
import com.rickandmortyapp.domain.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase,
    private val characterListMapper: CharacterListMapper<CharacterEntity, HomeUiData>
) : ViewModel() {

    private val _characterHomeUiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val characterHomeUiState = _characterHomeUiState.asStateFlow()

    init {
        getCharacters()
    }

    fun getCharacters(){
        viewModelScope.launch {
            getCharactersUseCase().collectLatest {
                when (it) {
                    is NetworkResponseState.Error -> {
                        _characterHomeUiState.emit(HomeUiState.Error(R.string.error))
                    }
                    NetworkResponseState.Loading -> {
                        _characterHomeUiState.emit(HomeUiState.Loading)
                    }
                    is NetworkResponseState.Success -> {
                        _characterHomeUiState.emit(HomeUiState.Success(characterListMapper.map(it.result)))
                    }
                }
            }
        }
    }

}