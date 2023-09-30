package com.example.test_app.data

import kotlinx.coroutines.flow.Flow

/**
 * Created by rivaldy on Oct/18/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

interface MovieRepository {
    fun getAllMovies(): Flow<List<Movie>>
    suspend fun insertMovie(movie: Movie)
    suspend fun updateMovie(movie: Movie)
//    suspend fun deleteMovie(note: Movie)
//    suspend fun deleteMovieById(id: Int)
}