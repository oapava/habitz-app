package com.habitz.ui.navigation
import com.example.habitz.R

sealed class BottomNavScreen(val route: String, val title: String, val icon: Int) {
    object Home : BottomNavScreen("home", "Inicio", R.drawable.home)
    object Settings : BottomNavScreen("settings", "Ajustes", R.drawable.setings)
    object Suggest : BottomNavScreen("suggest", "Sugerencias", R.drawable.suggest)
    object Following : BottomNavScreen("following", "Siguiendo", R.drawable.following)
    object Profile : BottomNavScreen("profile", "Perfil", R.drawable.profile)
}

val bottomNavItems = listOf(

    BottomNavScreen.Settings,
    BottomNavScreen.Suggest,
    BottomNavScreen.Home,
    BottomNavScreen.Profile,
    BottomNavScreen.Following,

)
