package com.example.mymovie.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mymovie.Model.Movie
import com.example.mymovie.Model.movieList
import com.example.mymovie.R

@Composable
fun MovieScreen(navController: NavController) {
    Column {
        MyMovieTopBarMovie()
        Spacer(modifier = Modifier.height(24.dp))

        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            SectionTitle(title = "Top Movies")
            TopMoviesRow(navController)

            Spacer(modifier = Modifier.height(16.dp))

            SectionTitle(title = "All Movies")
            AllMoviesColumn(navController)
        }
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(text = title, modifier = Modifier.padding(vertical = 8.dp))
}

@Composable
fun TopMoviesRow(navController: NavController) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(movieList) { movie ->
            MovieCard(
                movie = movie,
                modifier = Modifier.size(120.dp, 180.dp),
                onClick = { navController.navigate("detail/${movie.id}") }
            )
        }
    }
}

@Composable
fun AllMoviesColumn(navController: NavController) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(movieList) { movie ->
            MovieCard(
                movie = movie,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                onClick = { navController.navigate("detail/${movie.id}") }
            )
        }
    }
}

@Composable
fun MovieCard(movie: Movie, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Card(
        modifier = modifier
            .clickable(onClick = onClick)
            .shadow(4.dp, RoundedCornerShape(8.dp)),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Black
        )
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = movie.imageResId),
                contentDescription = movie.title,
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = movie.title,
                    color = Color.Yellow,
                    style = androidx.compose.material3.MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "Category: ${movie.category}",
                    color = Color.White,
                    style = androidx.compose.material3.MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyMovieTopBarMovie() {
    TopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.logo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(120.dp)
                        .padding(end = 20.dp)
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
    )
}
