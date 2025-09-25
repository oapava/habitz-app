package com.habitz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.*
import com.habitz.ui.navigation.BottomNavigationBar
import com.habitz.ui.navigation.BottomNavScreen
import com.habitz.ui.screens.AgendaRulesScreen
import com.habitz.ui.screens.CreateHabitScreen
import com.habitz.ui.screens.HomeScreen
import com.habitz.ui.screens.PermissionsScreen
import com.habitz.ui.screens.PhoneConfigScreen
import com.habitz.ui.screens.SettingsScreen
import com.habitz.ui.theme.GrayLight
import com.habitz.ui.theme.HabitzTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HabitzTheme {
                HabitzApp()
            }
        }
    }
}

@Composable
fun HabitzApp() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
        containerColor = GrayLight
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomNavScreen.Home.route,
            modifier = Modifier
                .padding(innerPadding)
        ) {
            composable(BottomNavScreen.Home.route) { HomeScreen(navController) }
            composable(BottomNavScreen.Settings.route) { SettingsScreen(navController) }
            // 👇 pantalla interna de Settings
            composable("agendaRules") { AgendaRulesScreen(navController) }

            // 👇 placeholders para que no rompa la navegación
            composable(BottomNavScreen.Profile.route) { Text("Pantalla Perfil") }
            composable(BottomNavScreen.Following.route) { Text("Pantalla Seguimiento") }
            composable(BottomNavScreen.Suggest.route) { Text("Pantalla Sugerencias") }

            composable("permissions") { PermissionsScreen(navController) }
            composable("phoneConfig") { PhoneConfigScreen(navController) }

            composable("createHabit") { CreateHabitScreen(navController) }

        }
    }
}
