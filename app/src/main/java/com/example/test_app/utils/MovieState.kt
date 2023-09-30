package com.example.test_app.utils

import com.example.test_app.data.Movie

data class MovieState(
    val movieList: List<Movie> = emptyList(),
    val title: String="",
    val rating: Double=1.0,
    val userRating: Int=1,
    val isWatched: Boolean=false
)
