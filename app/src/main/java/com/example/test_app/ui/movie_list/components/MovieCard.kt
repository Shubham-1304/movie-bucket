package com.example.test_app.ui.movie_list.components

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Content(
    val id: Int,
    val title: String,
    val rating: Double,
    val hasWatched: Boolean
)

@ExperimentalComposeUiApi
@Composable
fun ExpandaleCard(
    content: Content,
){

    Card(backgroundColor = Color(0xFF3A3B3C),shape = RoundedCornerShape(8.dp)) {
        var hasWatched by remember {
            mutableStateOf(content.hasWatched)
        }
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = hasWatched, colors = CheckboxDefaults.colors(
                    checkedColor = Color.Yellow.copy(0.7f),
                    uncheckedColor = Color.White,
                    checkmarkColor = Color.White
                ) ,onCheckedChange ={
                    hasWatched=!hasWatched
                } )
                Spacer(modifier = Modifier.size(8.dp))
                Text(text = "Title",
                    modifier = Modifier.weight(1f),
                    overflow = TextOverflow.Ellipsis,
                    color = Color.White,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(text = "Rating",
                    color = Color.White,
                    fontSize = 16.sp
                )
            }
            Spacer(modifier = Modifier.size(8.dp))
            ExpandableContent(hasWatched, content.rating)
        }
    }
}

@ExperimentalComposeUiApi
@Composable
fun ExpandableContent(
    isExpanded: Boolean,
    rating: Double
){
    val enterTransition= remember {
        expandVertically(
            expandFrom = Alignment.Top,
            animationSpec = tween(300)
        )+ fadeIn(initialAlpha = .3f, animationSpec = tween(300))
    }
    val exitTransition= remember {
        shrinkVertically(shrinkTowards = Alignment.Top,
        animationSpec = tween(300)
        )+ fadeOut(animationSpec = tween(300))
    }

    AnimatedVisibility(visible = isExpanded, enter = enterTransition, exit = exitTransition) {
        RatingBar(rating = 3)
    }
}