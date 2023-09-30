package com.example.test_app.ui.search.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.test_app.data.Movie
import com.example.test_app.ui.search.AddMovieEvent
import com.example.test_app.ui.search.AddMovieViewModel

@Composable
fun RoundedCornerButton(
    resultContent: Movie,
    viewModel: AddMovieViewModel = hiltViewModel()
) {
    Button(onClick = {
                     viewModel.onAddClick(AddMovieEvent.OnAddClicked(resultContent))
    },
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow.copy(0.8f))
    ) {
        Text("Add +")
    }
}

@Composable
fun AddedTextButton() {
    TextButton(onClick = { }, colors = ButtonDefaults.textButtonColors(contentColor=Color.White)) {
        Text("Added")
    }
}