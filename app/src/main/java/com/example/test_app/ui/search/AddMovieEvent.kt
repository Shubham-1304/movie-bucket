package com.example.test_app.ui.search

import com.example.test_app.data.Movie

sealed class AddMovieEvent{
    data class OnAddClicked(val movie:Movie): AddMovieEvent()
}
