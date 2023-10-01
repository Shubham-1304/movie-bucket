package com.example.test_app.data.remote.responses

data class SearchMovies(
    val entries: Int,
    val next: String,
    val page: Int,
    val results: List<Result>
)