package com.example.skytest

import androidx.lifecycle.MutableLiveData
import com.example.interactor.model.MovieModel
import com.example.viewmodel.MoviesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module{
        single{ MutableLiveData<List<MovieModel>>() }
        viewModel{ MoviesViewModel(get()) }
}