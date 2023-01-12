package com.example.interactor.model

import com.google.gson.annotations.SerializedName

data class SearchResultModel(@SerializedName("searchType") val searchType:String,
                             @SerializedName("expression") val expression:String,
                             @SerializedName("results") val results:List<MovieModel>,
                             @SerializedName("errorMessage") val errorMessage:String

)