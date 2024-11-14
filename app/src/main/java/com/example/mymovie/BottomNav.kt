package com.example.mymovie.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.GridOn
import androidx.compose.material.icons.filled.Info

import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier

import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.mymovie.MyAppNavHost

val GoldenYellow = Color(0xFFFFD700)
val White = Color.White

@Composable
fun BottomNav(navController: NavController) {
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    NavigationBar(
        containerColor = White,
        tonalElevation = 6.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(White, shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Default.Movie,
                    contentDescription = "Movies",
                    tint = if (currentRoute == "movie") GoldenYellow else Color.Black
                )
            },
            label = {
                Text(
                    "Movies",
                    color = if (currentRoute == "movie") GoldenYellow else Color.Black
                )
            },
            selected = currentRoute == "movie",
            onClick = {
                if (currentRoute != "movie") {
                    navController.navigate("movie") {
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            }
        )

        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Default.GridOn,
                    contentDescription = "Grid",
                    tint = if (currentRoute == "grid") GoldenYellow else Color.Black
                )
            },
            label = {
                Text(
                    "Grid",
                    color = if (currentRoute == "grid") GoldenYellow else Color.Black
                )
            },
            selected = currentRoute == "grid",
            onClick = {
                if (currentRoute != "grid") {
                    navController.navigate("grid") {
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            }
        )

        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Default.Info,
                    contentDescription = "About",
                    tint = if (currentRoute == "about") GoldenYellow else Color.Black
                )
            },
            label = {
                Text(
                    "About",
                    color = if (currentRoute == "about") GoldenYellow else Color.Black
                )
            },
            selected = currentRoute == "about",
            onClick = {
                if (currentRoute != "about") {
                    navController.navigate("about") {
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            }
        )
    }
}