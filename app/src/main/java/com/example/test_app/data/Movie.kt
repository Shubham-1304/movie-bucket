package com.example.test_app.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Movie(
    @PrimaryKey val id: String,
    val title: String,
    val rating: Double?,
    val userRating: Int=1,
    val isWatched: Int=0
)