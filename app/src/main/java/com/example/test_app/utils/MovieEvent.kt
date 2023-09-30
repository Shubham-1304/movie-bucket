package com.example.test_app.utils

sealed interface MovieEvent{
    object addMovie: MovieEvent
    data class setUserRating(val rating: Int):MovieEvent
    object watchStatus: MovieEvent
}