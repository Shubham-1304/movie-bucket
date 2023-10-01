package com.example.test_app.ui.movie_list.components

import android.view.MotionEvent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.*
import androidx.compose.runtime.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.test_app.data.Movie
import com.example.test_app.ui.movie_list.MovieListViewModel

@ExperimentalComposeUiApi
@Composable
fun RatingBar(
    movie: Movie,
    rating: Int,
    modifier: Modifier = Modifier,
    viewModel: MovieListViewModel = hiltViewModel()
) {
    var ratingState by remember {
        mutableStateOf(rating)
    }

    var selected by remember {
        mutableStateOf(false)
    }

    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        for (i in 1..10) {
            Icon(
                painter = painterResource(id = com.example.test_app.R.drawable.ic_rounded_star),
                contentDescription = "star",
                modifier = modifier
                    .width(30.dp)
                    .height(30.dp).clickable {
                        ratingState = i
                    }
                    .pointerInteropFilter {
                        when (it.action) {
                            MotionEvent.ACTION_DOWN -> {
                                selected = true
                                ratingState = i
                                viewModel.updateMovieRating(movie,ratingState)
                                println("OKKK: ${ratingState}")
                            }
                            MotionEvent.ACTION_UP -> {
                                selected = false
                                println("OK132: ${ratingState}")
                            }
                        }
                        true
                    },
                tint = if (i <= ratingState) Color(0xFFFFD700) else Color(0xFFA2ADB1)
            )
        }
    }
}