package com.example.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.interactor.MovieModel
import com.example.interactor.MoviesProvider

class MoviesViewModel() : ViewModel() {

    val movieModel = MutableLiveData<List<MovieModel>>()

    fun getMoviesData(){
        val MoviesData = MoviesProvider.listOfMovies
        movieModel.postValue(MoviesData)
    }

}