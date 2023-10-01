package com.example.test_app.ui.movie_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test_app.data.Movie
import com.example.test_app.data.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val repository: MovieRepository
): ViewModel() {

    val getAllMovies = repository.getAllMovies()

    fun updateMovieRating(movie:Movie,rating: Int){
        viewModelScope.launch {
            repository.updateMovie(Movie(movie.id, movie.title, movie.rating, rating,movie.isWatched))
        }
    }

    fun updateMovieWatchStatus(movie:Movie,status: Int){
        println("MOVIE BEFORE STATUS CHANGE: ${movie.isWatched} $status")
        viewModelScope.launch {
            repository.updateMovie(Movie(movie.id, movie.title, movie.rating, movie.userRating,status))
            println("MOVIE After STATUS CHANGE: ${movie.isWatched} $status")
        }
    }

}