package com.example.test_app.ui.search.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test_app.data.Movie


@Composable
fun ResultCard(
    resultContent: Movie,
){
    Card(backgroundColor = Color(0xFF3A3B3C),shape = RoundedCornerShape(8.dp)) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)) {
                Column(horizontalAlignment = Alignment.Start, modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Title",
                        overflow = TextOverflow.Ellipsis,
                        color = Color.White,
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(
                        text = "Rating",
                        color = Color.White,
                        fontSize = 16.sp
                    )
                }
                if (resultContent.isWatched==1) AddedTextButton() else RoundedCornerButton(resultContent)
            }
        }
    }
}