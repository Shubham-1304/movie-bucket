package com.example.test_app.ui.movie_list.components

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
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
import com.example.test_app.data.Movie


@ExperimentalComposeUiApi
@Composable
fun ExpandaleCard(
    content: Movie,
){

    Card(backgroundColor = Color(0xFF3A3B3C),shape = RoundedCornerShape(8.dp)) {
//        var hasWatched by remember {
//            mutableStateOf(content.hasWatched)
//        }
        var hasWatched by remember {
            mutableStateOf(content.isWatched)
        }
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = hasWatched==1, colors = CheckboxDefaults.colors(
                    checkedColor = Color.Yellow.copy(0.7f),
                    uncheckedColor = Color.White,
                    checkmarkColor = Color.White
                ) ,onCheckedChange ={
                    hasWatched=if(it==true) 1 else 0
                } )
                Spacer(modifier = Modifier.size(8.dp))
                Text(text = content.title,
                    modifier = Modifier.weight(1f),
                    overflow = TextOverflow.Ellipsis,
                    color = Color.White,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(text = "${content.rating}",
                    color = Color.White,
                    fontSize = 16.sp
                )
            }
            Spacer(modifier = Modifier.size(8.dp))
            ExpandableContent(hasWatched==1, if (content.rating!=null)content.rating else 0.0)
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