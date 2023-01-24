package com.example.skytest.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.interactor.model.MovieModel
import com.example.skytest.databinding.FragmentSearchBinding
import com.example.viewmodel.MoviesViewModel


class Search : Fragment(), SearchView.OnQueryTextListener {

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
        SearchBinding.MoviesSearchBar.setOnQueryTextListener(this)
    }

    private fun setMoviesViewModelObserver()
    {
        val observer = Observer<List<MovieModel>>{ movieList ->
            InitMoviesRecyclerView(movieList)
        }
        moviesViewModel.movieModel.observe(viewLifecycleOwner, observer)
    }

    private fun InitMoviesRecyclerView(movieList:List<MovieModel>) {
        with(SearchBinding.MoviesSearchlist){
            layoutManager = GridLayoutManager(context, 2)
            adapter = MoviesAdapter(movieList)
        }
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if(!query.isNullOrEmpty()){
            moviesViewModel.PerformSearch(query)
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }


}