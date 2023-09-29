package com.example.test_app.utils

sealed class Screens(val route: String){
    object SplashScreen: Screens("splash_screen")
    object MovieListScreen: Screens("movie_list_screen")
    object SearchScreen: Screens("search_screen")
}
