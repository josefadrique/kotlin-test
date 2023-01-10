package com.example.skytest.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.interactor.MovieModel
import com.example.skytest.R
import com.example.skytest.databinding.FragmentSearchBinding
import com.example.viewmodel.MoviesViewModel


class Search : Fragment() {

    private var fragmentSearchBinding: FragmentSearchBinding? = null
    private val SearchBinding get() = fragmentSearchBinding!!
    private val moviesViewModel:MoviesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentSearchBinding = FragmentSearchBinding.inflate(inflater, container, false)
        return SearchBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setMoviesViewModelObserver()
        moviesViewModel.getMoviesData() //This should be called inside MoviesViewModel, calling here until the interactor is finished
    }

    private fun setMoviesViewModelObserver()
    {
        val observer = Observer<List<MovieModel>>{ movieList ->
            InitMoviesRecyclerView(movieList)
        }
        moviesViewModel.movieModel.observe(viewLifecycleOwner, observer)
    }

    private fun InitMoviesRecyclerView(movieList:List<MovieModel>)
    {
        val moviesRecyclerView = SearchBinding.MoviesSearchlist
        moviesRecyclerView.layoutManager = GridLayoutManager(moviesRecyclerView.context, 2)
        moviesRecyclerView.adapter = MoviesAdapter(movieList)

    }
}