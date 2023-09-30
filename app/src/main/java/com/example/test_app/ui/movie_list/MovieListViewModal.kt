package com.example.test_app.ui.movie_list

import androidx.lifecycle.ViewModel
import com.example.test_app.data.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val repository: MovieRepository
): ViewModel() {

    val getAllMovies = repository.getAllMovies()

}