package com.example.test_app.data

import com.example.test_app.data.remote.MovieApi
import com.example.test_app.data.remote.responses.SearchMovies
import com.example.test_app.utils.Resource
import javax.inject.Inject
import com.example.test_app.data.remote.responses.Result
import com.example.test_app.data.remote.responses.Results


class MovieRepositoryImpl @Inject constructor(
    private val movieDao: MovieDao,
    private val api: MovieApi
) : MovieRepository {

    override fun getAllMovies() = movieDao.getAllMovies()

    override suspend fun insertMovie(movie: Movie) = movieDao.insertMovie(movie)

    override suspend fun updateMovie(movie: Movie) = movieDao.updateMovie(movie)

    override suspend fun getSearchMovieList(searchTitle: String): Resource<List<Result>> {
        val response=try{
            api.getMovieList(searchTitle,false)
        }catch (e:Exception){
            println("Error: $e")
            return Resource.Error("Error occurred: $e")
        }
        return Resource.Success(data=response.results)
    }

    override suspend fun getMovieRating(movieId: String): Resource<Results> {
        val response=try{
            api.getMovieRating(movieId)
        }catch (e:Exception){
            println("Error: $e")
            return Resource.Error("Error occurred: $e")
        }
        println("DATA : $response")
        return Resource.Success(response.results)
    }

}