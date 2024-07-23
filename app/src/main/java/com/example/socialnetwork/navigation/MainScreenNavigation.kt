package com.example.socialnetwork.navigation

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.socialnetwork.presentation.posts.HomeFeedScreen
import com.example.socialnetwork.presentation.posts.HomeViewModel
import com.example.socialnetwork.presentation.user.ProfileScreen
import kotlinx.coroutines.CoroutineScope

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreenNavigation(
    navController: NavHostController,
    mainNavController: NavHostController,
    scope: CoroutineScope,
    snackBarHostState: SnackbarHostState,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    Scaffold {

        NavHost(
            navController = mainNavController,
            startDestination = Screens.HomeFeedScreen.route
        ) {

            //home feed screen
            composable(Screens.HomeFeedScreen.route) {
                HomeFeedScreen(navHostController = mainNavController, homeViewModel)
            }

            //profile screen
            composable(Screens.ProfileScreen.route) {
                ProfileScreen(
                    navHostController = mainNavController,
                )
            }
        }
    }
}