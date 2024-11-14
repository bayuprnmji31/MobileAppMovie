package com.example.mymovie.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mymovie.Model.movieList
import com.example.mymovie.ui.theme.BottomNav

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(itemId: String?, navController: NavController) {
    val movieId = itemId?.toIntOrNull()
    val movie = movieList.find { it.id == movieId }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Detail Movie", color = Color.Black)
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.Black
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.Yellow
                )
            )
        },
        content = { paddingValues ->
            movie?.let {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = movie.imageResId),
                        contentDescription = movie.title,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp)
                            .padding(8.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Black
                        ),
                        elevation = CardDefaults.cardElevation(8.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = movie.title,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Yellow,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = "Category: ${movie.category}",
                                fontSize = 16.sp,
                                color = Color.Yellow,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            Text(
                                text = movie.description,
                                fontSize = 14.sp,
                                color = Color.White,
                                textAlign = TextAlign.Start
                            )
                        }
                    }
                }
            } ?: run {
                Text(
                    text = "Movie not found.",
                    textAlign = TextAlign.Center,
                    color = Color.Red,
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                )
            }
        }
    )
}
