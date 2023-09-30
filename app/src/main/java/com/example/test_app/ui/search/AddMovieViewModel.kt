package com.example.test_app.ui.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test_app.data.Movie
import com.example.test_app.data.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddMovieViewModel @Inject constructor(
    private val repository: MovieRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    var movie by mutableStateOf<Movie?>(null)
        private set

    var title by mutableStateOf("")
        private set

    var rating by mutableStateOf(1.0)
        private set

    var isWatched by mutableStateOf(0)
        private set

    fun onAddClick(event: AddMovieEvent) {
        when (event) {
            is AddMovieEvent.OnAddClicked -> {
                movie = event.movie
                viewModelScope.launch {
                    repository.insertMovie(movie!!)
                }
            }
        }
    }


}
