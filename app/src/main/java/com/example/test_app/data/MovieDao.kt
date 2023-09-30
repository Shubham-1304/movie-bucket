package com.example.test_app.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Upsert
    suspend fun insertMovie(movie: Movie)

    @Update
    suspend fun updateMovie(movie: Movie)

//    @Delete
//    suspend fun deleteMovie(movie: Movie)

    @Query("SELECT * FROM movie")
    fun getAllMovies(): Flow<List<Movie>>
    // why not use suspend ? because Room does not support LiveData with suspended functions.
    // LiveData already works on a background thread and should be used directly without using coroutines


//    @Query("DELETE FROM movie_table WHERE id = :id") //you can use this too, for delete note by id.
//    suspend fun deleteMovieById(id: Int)
}

