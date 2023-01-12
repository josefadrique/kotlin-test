package com.example.interactor

import com.example.interactor.core.RetroFitHelper
import com.example.interactor.model.MovieModel
import com.example.interactor.model.SearchResultModel
import com.example.interactor.network.SearchApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.http.Url

class MoviesProvider {

    companion object {
        private val retrofit = RetroFitHelper.GetRetroFit()

        suspend fun GetSearchResponse(@Url url: String): SearchResultModel {
            return withContext(Dispatchers.IO) {
                val response = retrofit.create(SearchApiClient::class.java).GetSearchResponse(url)
                response.body() ?: SearchResultModel("", "", emptyList(), "")
            }
        }
    }
}