package com.example.test_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import kotlinx.coroutines.delay
import kotlin.random.Random
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.test_app.ui.splash.SplashScreen
import com.example.test_app.utils.Navigation
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalComposeUiApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent{
            Surface(color = Color(0xFF3A3B3C), modifier = Modifier.fillMaxSize()) {
                Navigation()
            }
        }
    }
}

@Composable
fun ChangeColor(modifier: Modifier = Modifier, updateColor: (Color) -> Unit) {
    Box(
        modifier
            .background(Color.Red)
            .clickable {
                updateColor(Color(Random.nextFloat(), Random.nextFloat(), Random.nextFloat(), 1f))
            })

}

@Composable
fun MainScreen(navController: NavController) {
    println(navController)
    Column(modifier = Modifier.fillMaxSize()) {
        val boxColor = remember {
            mutableStateOf(Color.Blue)
        }
        val myLambda: (Color) -> Unit = { s: Color -> boxColor.value = s }
        ChangeColor(
            Modifier
                .weight(1f)
                .fillMaxSize(), myLambda
        )
        Box(
            Modifier
                .weight(1f)
                .fillMaxSize()
                .background(color = boxColor.value)
        )
    }
}
