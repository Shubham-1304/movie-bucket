package com.example.test_app.ui.movie_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.test_app.ui.movie_list.components.ExpandaleCard
import com.example.test_app.utils.Screens


@ExperimentalComposeUiApi
@Composable
fun MovieListScreen(
    navController: NavController,
    viewModel: MovieListViewModel = hiltViewModel()

) {
    val allMovies = viewModel.getAllMovies.collectAsState(initial = emptyList())

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screens.SearchScreen.route)
                }
            ) {
                Icon(Icons.Filled.Add, "")
            }
        },
        backgroundColor = Color.Black,
        content = { padding ->
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier
                    .padding(padding)
                    .padding(vertical = 20.dp)
            ) {
                items(allMovies.value) { content ->
                    ExpandaleCard(
                        content = content
                    )
                }
            }
        })
}