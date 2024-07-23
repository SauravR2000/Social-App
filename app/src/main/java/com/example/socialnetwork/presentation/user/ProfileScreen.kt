package com.example.socialnetwork.presentation.user

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScreen(
    navHostController: NavHostController,
    profileViewModel: ProfileViewModel = hiltViewModel(),
) {

    val gradientBrush = Brush.verticalGradient(
        colors = listOf(Color(0xFF00A7DB), Color(0xFF162676))
    )

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp

    val profileImageRadius = 150;

    LaunchedEffect(key1 = Unit) {
        profileViewModel.getUserDetail()
    }

    Scaffold {
        Column(
            modifier = Modifier.fillMaxSize(),

            ) {
            UserDetailComponent(screenHeight, gradientBrush, profileImageRadius, profileViewModel)
        }
    }
}


