package com.rickandmortyapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.rickandmortyapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var  binding: FragmentHomeBinding

    private val viewModel by viewModels<HomeViewModel>()

    private val adapter = CharacterAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater).apply {
            rvCharacterList.adapter = adapter
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeUiState()
    }

    private fun observeUiState(){
        lifecycleScope.launchWhenStarted {
            viewModel.characterHomeUiState.collectLatest {
                when(it){
                    is HomeUiState.Error -> {
                        Toast.makeText(requireContext(), getString(it.message), Toast.LENGTH_LONG)
                        .show()
                    }
                    HomeUiState.Loading -> {
                        Toast.makeText(requireContext(), "Loading", Toast.LENGTH_LONG).show()
                    }
                    is HomeUiState.Success -> {
                        handleSuccessUiState(it.data)
                    }
                }
            }
        }
    }

    private fun handleSuccessUiState(data: List<HomeUiData>) {
        adapter.updateItems(data)
    }
}