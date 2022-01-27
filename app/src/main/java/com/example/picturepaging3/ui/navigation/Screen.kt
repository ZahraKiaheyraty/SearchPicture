package com.example.picturepaging3.ui.navigation

sealed class Screen(val route: String){
    object Intro: Screen("intro_screen")
    object Home: Screen("home_screen")
    object Search: Screen("search_screen")
}