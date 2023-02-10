package com.rickandmortyapp.ui.home

import android.view.ViewGroup
import com.rickandmortyapp.databinding.AdapterCharacterItemBinding
import com.rickandmortyapp.ui.base.BaseViewHolder
import com.rickandmortyapp.utilty.inflateAdapterItem

class CharacterViewHolder(private val binding: AdapterCharacterItemBinding)
    :BaseViewHolder<HomeUiData>(binding.root){

    companion object {
        fun createFrom(parent: ViewGroup) =
            CharacterViewHolder(parent.inflateAdapterItem(AdapterCharacterItemBinding::inflate))
    }

    override fun onBind(data: HomeUiData) {
        binding.characterComponent.setCharacterData(data)
    }
}