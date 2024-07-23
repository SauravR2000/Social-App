package com.example.socialnetwork.navigation

sealed class Screens(var route: String) {
    object LoginScreen : Screens("login_screen")
    object RegisterScreen : Screens("register_screen")
    object HomeFeedScreen : Screens("home_feed_screen")
    object ProfileScreen : Screens("profile_screen")
    object MainScreen : Screens("main_screen")
}