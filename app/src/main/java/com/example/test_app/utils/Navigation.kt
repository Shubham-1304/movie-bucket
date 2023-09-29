package com.example.test_app.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.test_app.MainScreen
import com.example.test_app.ui.movie_list.MovieListScreen
import com.example.test_app.ui.search.SearchScreen
import com.example.test_app.ui.splash.SplashScreen

@ExperimentalComposeUiApi
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.SplashScreen.route) {
        composable(Screens.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(Screens.MovieListScreen.route) {
            MovieListScreen(navController=navController)
        }
        composable(Screens.SearchScreen.route) {
            SearchScreen(navController = navController)
        }
    }
}