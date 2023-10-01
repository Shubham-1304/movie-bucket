package com.example.test_app.data

import com.example.test_app.data.remote.responses.SearchMovies
import com.example.test_app.utils.Resource
import kotlinx.coroutines.flow.Flow
import com.example.test_app.data.remote.responses.Result
import com.example.test_app.data.remote.responses.Results


interface MovieRepository {
    fun getAllMovies(): Flow<List<Movie>>
    suspend fun insertMovie(movie: Movie)
    suspend fun updateMovie(movie: Movie)
//    suspend fun deleteMovie(note: Movie)
//    suspend fun deleteMovieById(id: Int)

    suspend fun getSearchMovieList(searchTitle: String): Resource<List<Result>>

    suspend fun getMovieRating(movieId: String): Resource<Results>
}