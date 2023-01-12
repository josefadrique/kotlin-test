package com.example.interactor.network

import com.example.interactor.model.SearchResultModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface SearchApiClient {
    @GET
    suspend fun GetSearchResponse(@Url url:String):Response<SearchResultModel>
}