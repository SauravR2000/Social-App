package com.example.socialnetwork.navigation

sealed class Screens(var route: String) {
    object LoginScreen : Screens("login_screen")
    object RegisterScreen : Screens("register_screen")
    object HomeFeedScreen : Screens("home_feed_screen")
}