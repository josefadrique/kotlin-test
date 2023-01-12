package com.example.interactor.model

import com.google.gson.annotations.SerializedName

data class MovieModel(@SerializedName("id") val id:String,
                      @SerializedName("resultType") val resultType:String,
                      @SerializedName("image") val image:String,
                      @SerializedName("title") val title: String,
                      @SerializedName("description") val description:String)