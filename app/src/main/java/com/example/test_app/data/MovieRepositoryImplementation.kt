package com.example.test_app.data

import javax.inject.Inject


class MovieRepositoryImpl @Inject constructor(private val movieDao: MovieDao) : MovieRepository {

    override fun getAllMovies() = movieDao.getAllMovies()

    override suspend fun insertMovie(movie: Movie) = movieDao.insertMovie(movie)

    override suspend fun updateMovie(movie: Movie) = movieDao.updateMovie(movie)

//    override suspend fun deleteMovie(movie: Movie) = movieDao.deleteMovie(movie)
//
//    override suspend fun deleteMovieById(id: Int) = movieDao.deleteMovieById(id)

}