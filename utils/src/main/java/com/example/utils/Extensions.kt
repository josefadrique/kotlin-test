package com.example.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun ImageView.loadUrl(context: Context, url:String){
        Glide.with(context).load(url).into(this)
    }

fun Retrofit.createRetrofitInstance(baseUrl:String) : Retrofit = Retrofit.Builder()
    .baseUrl(baseUrl)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
