package com.example.test_app.ui.search

import androidx.compose.runtime.*
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test_app.data.Movie
import com.example.test_app.data.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddMovieViewModel @Inject constructor(
    private val repository: MovieRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    var moviesList by mutableStateOf(mutableListOf<Movie>())
        private set

    val movies: MutableState<MutableList<Movie>> =
        mutableStateOf(mutableListOf())

    var searchTitle by mutableStateOf("")

//    var rating by mutableStateOf(1.0)
//        private set

//    var isWatched by mutableStateOf(0)
//        private set

    fun onSearchClick() {
        viewModelScope.launch {

            val response = repository.getSearchMovieList(searchTitle)
            println("RESPONSE: ${response.data} $searchTitle")
            response.data?.map { it ->
                val rating = repository.getMovieRating(it.id).data?.averageRating
                moviesList.add(
                    Movie(
                        it.id,
                        it.titleText.text,
                        rating
                    )
                )

            }
            movies.value = moviesList
//                    response.data?.map {it-> movies.value.add(Movie(it.id,it.titleText.text,9.0))}
//                    println("RESPONSE SIZE: ${response.data?.size} SIZE: ${ moviesList.size }")
            println("RESPONSE SIZE: ${response.data?.size} SIZE: ${movies.value.size} ${moviesList.size}")
        }
    }

    fun onAddClick(event: AddMovieEvent, index: Int) {
        when (event) {
            is AddMovieEvent.OnAddClicked -> {
//                movie = event.movie
                viewModelScope.launch {
                    val movie = movies.value[index]
                    repository.insertMovie(movie)
                }
            }
        }
    }

    fun getWatchList(): Flow<List<Movie>> {
        return repository.getAllMovies()

    }


}
