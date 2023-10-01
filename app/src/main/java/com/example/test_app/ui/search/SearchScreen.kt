package com.example.test_app.ui.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.test_app.data.Movie
import com.example.test_app.ui.movie_list.MovieListViewModel
import com.example.test_app.ui.search.components.ResultCard
import com.example.test_app.ui.search.components.SearchBar


@Composable
fun SearchScreen(
    navController: NavController,
    viewModel: AddMovieViewModel = hiltViewModel()
) {
    Scaffold(
        backgroundColor = Color.Black,
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .statusBarsPadding()
            ) {
                SearchBar(
                    onValueChange = {
//                event(SearchEvent.UpdateSearchQuery(it))
                    },
                    onSearch = {
//                event(SearchEvent.SearchNews)
                    }
                )
                Button(onClick = {
                    viewModel.onSearchClick()
                },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow.copy(0.8f))
                ) {
                    Text("SEARCH")
                }
                val existingMovies=viewModel.getWatchList().collectAsState(initial = emptyList())
                val existingIds= mutableListOf<String>()
                existingMovies.value.map {
                    existingIds.add(it.id)
                }
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier
                        .padding(padding)
                        .padding(vertical = 20.dp)
                ) {
                    items(viewModel.movies.value.size) { content ->
                        ResultCard(
                            resultContent = viewModel.movies.value[content],
                            content,
                            viewModel.movies.value[content].id in existingIds
                        )
                    }
                }
            }
        }
    )
//    Column(
//        modifier = Modifier
//            .padding(8.dp)
//            .statusBarsPadding()
//    ) {
//        SearchBar(
//            text = "",
//            readOnly = false,
//            onValueChange = {
////                event(SearchEvent.UpdateSearchQuery(it))
//                            },
//            onSearch = {
////                event(SearchEvent.SearchNews)
//            }
//        )

}