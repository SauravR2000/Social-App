package com.example.socialnetwork.presentation.posts

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import com.example.socialnetwork.components.CustomAppBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeFeedScreen(
    navHostController: NavHostController,
    homeViewModel: HomeViewModel,
) {


    //launch scope
    LaunchedEffect(key1 = Unit) {
        homeViewModel.getAllPosts()
    }

    //UI
    Scaffold(
        topBar = { CustomAppBar(title = "Home", navController = navHostController) }
    ) {
        Text(text = "Home Page")
    }
}