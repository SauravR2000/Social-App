package com.example.socialnetwork.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.socialnetwork.presentation.auth.register.RegisterUserViewModel
import com.example.socialnetwork.presentation.auth.login.LoginScreen
import com.example.socialnetwork.presentation.auth.login.LoginViewModel
import com.example.socialnetwork.presentation.auth.register.RegisterScreen
import com.example.socialnetwork.presentation.posts.HomeFeedScreen
import com.example.socialnetwork.presentation.posts.HomeViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Navigation(
    navController: NavHostController = rememberNavController(),
    loginViewModel: LoginViewModel = hiltViewModel(),
    registerViewModel: RegisterUserViewModel = hiltViewModel(),
    homeViewModel: HomeViewModel = hiltViewModel(),
) {

    val scope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState)
        },
    ) {
        NavHost(
            navController = navController,
            startDestination = Screens.LoginScreen.route,
            modifier = Modifier.safeContentPadding(),
        ) {
            composable(Screens.LoginScreen.route) {
                LoginScreen(
                    navHostController = navController,
                    loginViewModel,
                    scope,
                    snackBarHostState
                )
            }

            composable(Screens.RegisterScreen.route) {
                RegisterScreen(navController, registerViewModel, scope, snackBarHostState)
            }

            composable(Screens.HomeFeedScreen.route) {
                HomeFeedScreen(navHostController = navController, homeViewModel)
            }
        }
    }
}