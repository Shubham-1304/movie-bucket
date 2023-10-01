package com.example.test_app.data.remote

import com.example.test_app.data.remote.responses.SearchMovies
import com.example.test_app.data.remote.responses.rating
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
    @Headers(
        "X-RapidAPI-Key: b18183179amsh3e3a420f5aa7229p14ee4fjsnb0e7aa34b80b",
        "X-RapidAPI-Host: moviesdatabase.p.rapidapi.com"
    )
    @GET("search/title/{searchTitle}")
    suspend fun getMovieList(
        @Path("searchTitle") searchTitle: String,
        @Query("exact") exact: Boolean
    ): SearchMovies

    @Headers(
        "X-RapidAPI-Key: b18183179amsh3e3a420f5aa7229p14ee4fjsnb0e7aa34b80b",
        "X-RapidAPI-Host: moviesdatabase.p.rapidapi.com"
    )
    @GET("{movieId}/ratings")
    suspend fun getMovieRating(
        @Path("movieId") movieId: String
    ): rating

}