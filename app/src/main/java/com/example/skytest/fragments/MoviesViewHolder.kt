package com.example.skytest.fragments;

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.interactor.MovieModel
import com.example.skytest.R

class MoviesViewHolder(view : View) : RecyclerView.ViewHolder(view) {

    val holderTextView = view.findViewById<TextView>(R.id.TitleTextView)
    val holderImage = view.findViewById<ImageView>(R.id.MovieImageView)

    fun renderView(model:MovieModel){
        holderTextView.setText(model.title)
    }
}
