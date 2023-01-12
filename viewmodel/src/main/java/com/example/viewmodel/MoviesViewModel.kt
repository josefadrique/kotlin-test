package com.example.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.interactor.MoviesProvider
import com.example.interactor.model.MovieModel
import kotlinx.coroutines.launch

class MoviesViewModel() : ViewModel() {

    val movieModel = MutableLiveData<List<MovieModel>>()

    fun PerformSearch(query:String){
        viewModelScope.launch {
            val result = MoviesProvider.GetSearchResponse(query)
            result?.let{
                movieModel.postValue(result.results)
            }
        }
    }

}