package com.rickandmortyapp.ui.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import coil.load
import com.rickandmortyapp.databinding.LayoutCharacterBinding
import com.rickandmortyapp.ui.home.HomeUiData

class CharacterUiComponent @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    FrameLayout(context, attributeSet, defStyleAttr) {

    private val binding = LayoutCharacterBinding.inflate(LayoutInflater.from(context), this, false)

    init {
        addView(binding.root)
    }

    fun setCharacterData(homeUiData: HomeUiData) {
        binding.tvName.text = homeUiData.name
        binding.status.text = homeUiData.status
        binding.ivCharacter.load(homeUiData.image)
    }
}