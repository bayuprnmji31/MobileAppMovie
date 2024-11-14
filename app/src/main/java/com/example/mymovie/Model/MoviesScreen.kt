package com.example.mymovie.Model

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoviesScreen(navController: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Movies") }) }) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            LazyColumn(modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)) {
                items(10) { index ->
                    MovieItem(
                        title = "Movie $index",
                        onClick = { navController.navigate("movieDetail/$index") }
                    )
                }
            }

            LazyRow(modifier = Modifier.fillMaxWidth()) {
                items(10) { index ->
                    MovieItem(
                        title = "Recommended $index",
                        onClick = { navController.navigate("movieDetail/$index") }
                    )
                }
            }
        }
    }
}

@Composable
fun MovieItem(title: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(16.dp)
        )
    }
}
