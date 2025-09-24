package com.habitz.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.habitz.R

sealed class BottomNavScreen(val route: String, val title: String, val icon: Int) {
    object Settings : BottomNavScreen("settings", "Ajustes", R.drawable.setings)
    object Suggest : BottomNavScreen("settings", "Perfil", R.drawable.suggest)
    object Home : BottomNavScreen("home", "Inicio", R.drawable.home)
    object Following : BottomNavScreen("settings", "Perfil", R.drawable.following)
    object Profile : BottomNavScreen("settings", "Perfil", R.drawable.profile)
}

val bottomNavItems = listOf(
    BottomNavScreen.Home,
    BottomNavScreen.Settings,
    BottomNavScreen.Profile,
    BottomNavScreen.Following,
    BottomNavScreen.Suggest,
)
