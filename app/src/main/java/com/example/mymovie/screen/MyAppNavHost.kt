package com.example.mymovie

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mymovie.screen.MovieScreen
import com.example.mymovie.screen.GridScreen
import com.example.mymovie.screen.AboutScreen
import com.example.mymovie.screen.DetailScreen

@Composable
fun MyAppNavHost(
    navController: NavHostController,
    startDestination: String = "movie",
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable("movie") {
            MovieScreen(navController = navController)
        }
        composable("grid") {
            GridScreen(navController = navController)
        }
        composable("about") {
            AboutScreen()
        }
        composable("detail/{movieId}") { backStackEntry ->
            val movieId = backStackEntry.arguments?.getString("movieId")
            if (movieId != null) {
                DetailScreen(itemId = movieId, navController = navController)
            } else {
                println("movieId is null")
            }
        }
    }
}
