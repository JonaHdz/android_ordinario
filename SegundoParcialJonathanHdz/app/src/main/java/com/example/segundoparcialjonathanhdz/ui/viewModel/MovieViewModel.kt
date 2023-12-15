package com.example.segundoparcialjonathanhdz.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.segundoparcialjonathanhdz.data.model.MovieDomain
import com.example.segundoparcialjonathanhdz.domain.GetAllMoviesUseCase
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel(){
    val movieViewModel = MutableLiveData<MovieDomain>()
    var getAllMoviesUseCase = GetAllMoviesUseCase()

    fun onCreate() {
        viewModelScope.launch {
            val result = getAllMoviesUseCase()
            if (!result.isNullOrEmpty()) {
                movieViewModel.postValue(result[0])
            }
        }
    }
}