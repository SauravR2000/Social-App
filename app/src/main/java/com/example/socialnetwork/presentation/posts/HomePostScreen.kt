package com.example.socialnetwork.presentation.posts

import android.graphics.Paint.Align
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.PullRefreshState
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.socialnetwork.components.CustomCircularLoading
import com.example.socialnetwork.components.CustomAppBar
import com.example.socialnetwork.state.UiState

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeFeedScreen(
    navHostController: NavHostController,
    homeViewModel: HomeViewModel,
) {

    //state
    val state =
        homeViewModel.homeData.collectAsState(initial = UiState.LOADING()).value
    var isRefreshing by remember {
        mutableStateOf(false)
    }
    val scope = rememberCoroutineScope()
    val pullRefreshState = rememberPullRefreshState(
        refreshing = isRefreshing,
        onRefresh = { homeViewModel.getAllPosts() }
    )


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
                .pullRefresh(state = pullRefreshState)
        ) {
            when (state) {
                is UiState.LOADING -> {
                    CustomCircularLoading()
                }

                is UiState.SUCCESS -> {
                    isRefreshing = false
                    PostsListView(
                        navHostController = navHostController,
                        postListModel = state.data!!
                    )
                }

                is UiState.ERROR -> {
                    isRefreshing = false
                    Text(text = state.error.toString())
                }

                else -> {
                    Text(text = "Sorry Something Went Wrong")
                }

            }
            PullRefreshIndicator(
                refreshing = isRefreshing,
                state = pullRefreshState,
                modifier = Modifier.align(Alignment.TopCenter)
            )

        }
    }
}