package com.example.test_app.ui.movie_list

import com.example.test_app.data.Movie

sealed class MovieListEvent {
    data class OnDeleteTodoClick(val movie: Movie): MovieListEvent()
    data class OnDoneChange(val movie: Movie, val isDone: Boolean): MovieListEvent()
    object OnUndoDeleteClick: MovieListEvent()
    data class OnTodoClick(val movie: Movie): MovieListEvent()
    object OnAddTodoClick: MovieListEvent()
}
