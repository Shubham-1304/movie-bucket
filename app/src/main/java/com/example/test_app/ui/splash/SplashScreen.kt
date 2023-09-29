package com.example.test_app.ui.splash

import android.media.MediaPlayer
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.test_app.R
import com.example.test_app.utils.Screens
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController) {
    val mContext = LocalContext.current
    val popcornMediaPlayer = MediaPlayer.create(mContext, R.raw.popcorn)
    val strawMediaPlayer = MediaPlayer.create(mContext, R.raw.straw)
    LaunchedEffect(key1 = true) {
        delay(6000L)
//        navController.navigate(Screens.SearchScreen.route)
//        navController.navigate("main_screen")
        navController.navigate(Screens.MovieListScreen.route)
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column() {
            var coldrinkAnimation by remember {
                mutableStateOf(false)
            }
            var timeLeft by remember { mutableStateOf(3) }
            LaunchedEffect(key1 = timeLeft) {
                if (timeLeft==3)
                    popcornMediaPlayer.start()
                while (timeLeft > 0) {
                    delay(1000L)
                    timeLeft--
                    println("$timeLeft")
                }
                if (timeLeft == 0 && coldrinkAnimation == false) {
                    coldrinkAnimation = true
                    popcornMediaPlayer.stop()
                    strawMediaPlayer.start()
                }
            }
            val horizontalOffset by animateDpAsState(
                targetValue = if (coldrinkAnimation) 0.dp else 300.dp,
                animationSpec = tween(durationMillis = 500)
            )
            var popcornAnimation by remember {
                mutableStateOf(false)
            }
            var timeLeft2 by remember { mutableStateOf(2) }
            LaunchedEffect(key1 = timeLeft2) {
                while (timeLeft2 > 0) {
                    delay(1000L)
                    timeLeft2--
                    println("$timeLeft2")
                }
                if (timeLeft2 == 0 && popcornAnimation == false) {
                    popcornAnimation = true
                    strawMediaPlayer.stop()
                }
            }
            val leftHorizontalOffset by animateDpAsState(
                targetValue = if (popcornAnimation) 0.dp else -(300).dp,
                animationSpec = tween(durationMillis = 500)
            )
            Row(horizontalArrangement = Arrangement.Center) {
                SplashText(text = "Movie")
                Box(modifier = Modifier.offset(horizontalOffset, 0.dp)) {
                    ImageIcon(
                        painter = painterResource(id = R.drawable.cold_drink),
                        contentDescription = "colddrink icon"
                    )
                }
            }
            Row(horizontalArrangement = Arrangement.Center) {
                Box(modifier = Modifier.offset(leftHorizontalOffset, 0.dp)) {
                    ImageIcon(
                        painter = painterResource(id = R.drawable.popcorn),
                        contentDescription = "popcorn icon"
                    )
                }
                SplashText(text = "Bucket")
            }
        }
    }
}

@Composable
fun SplashText(text: String) {
    Text(text, color = Color(0xFFFFFFFF), fontSize = 40.sp, fontWeight = FontWeight.Bold)
}

@Composable
fun ImageIcon(painter: Painter, contentDescription: String) {
    Image(
        painter = painter, contentDescription = contentDescription,
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .width(60.dp)
            .height(60.dp)
    )

}

