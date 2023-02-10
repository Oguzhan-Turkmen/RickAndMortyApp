package com.rickandmortyapp.ui.home

import android.view.ViewGroup
import com.rickandmortyapp.ui.base.BaseRecyclerViewAdapter

class CharacterAdapter: BaseRecyclerViewAdapter<HomeUiData,CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder.createFrom(parent)
    }

}