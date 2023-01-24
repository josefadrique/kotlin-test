package com.example.skytest.fragments;

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.interactor.model.MovieModel
import com.example.skytest.R
import com.example.utils.loadUrl


class MoviesViewHolder(view : View) : RecyclerView.ViewHolder(view) {

    val holderTextView = view.findViewById<TextView>(R.id.TitleTextView)
    val holderImage = view.findViewById<ImageView>(R.id.MovieImageView)

    fun renderView(model: MovieModel){
        holderTextView.setText(model.title)
        val imageUrl = model.image
        //Glide.with(holderImage.context).load(imageUrl).into(holderImage)
        holderImage.loadUrl(holderImage.context, imageUrl)
    }
}
