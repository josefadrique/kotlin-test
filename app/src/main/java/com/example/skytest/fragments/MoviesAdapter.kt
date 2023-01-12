package com.example.skytest.fragments;
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView;
import com.example.interactor.model.MovieModel
import com.example.skytest.R

class MoviesAdapter(val movieDataList:List<MovieModel>) : RecyclerView.Adapter<MoviesViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MoviesViewHolder(layoutInflater.inflate(R.layout.movieitem, parent, false))
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movieModel = movieDataList[position]
        holder.renderView(movieModel)
    }

    override fun getItemCount(): Int = movieDataList.size
}
