package com.example.socialnetwork.presentation.posts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.socialnetwork.components.CustomCircularLoading
import com.example.socialnetwork.components.CustomAppBar
import com.example.socialnetwork.state.UiState

@Composable
fun HomeFeedScreen(
    navHostController: NavHostController,
    homeViewModel: HomeViewModel,
) {

    //state
    val state =
        homeViewModel.homeData.collectAsState(initial = UiState.LOADING()).value


    //launch scope
    LaunchedEffect(key1 = Unit) {
        homeViewModel.getAllPosts()
    }

    //UI
    Scaffold(
        topBar = { CustomAppBar(title = "Home Feed", navController = navHostController) }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            when (state) {
                is UiState.LOADING -> {
                    CustomCircularLoading()
                }

                is UiState.SUCCESS -> {
                    PostsListView(
                        navHostController = navHostController,
                        postListModel = state.data!!
                    )
                }

                is UiState.ERROR -> {
                    Text(text = state.error.toString())
                }

                else -> {
                    Text(text = "Sorry Something Went Wrong")
                }
            }
        }
    }
}