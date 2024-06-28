package com.example.socialnetwork.navigation

import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.socialnetwork.presentation.auth.AuthViewModel
import com.example.socialnetwork.presentation.auth.login.LoginScreen
import com.example.socialnetwork.presentation.auth.register.RegisterScreen


@Composable
fun Navigation(
    navController: NavHostController = rememberNavController(),
    authViewModel: AuthViewModel = hiltViewModel(),
) {
    NavHost(
        navController = navController,
        startDestination = Screens.LoginScreen.route,
        modifier = Modifier.safeContentPadding(),
    ) {
        composable(Screens.LoginScreen.route) {
            LoginScreen(navHostController = navController, authViewModel)
        }

        composable(Screens.RegisterScreen.route) {
            RegisterScreen(navController, authViewModel)
        }
    }
}