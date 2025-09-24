package com.habitz.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.habitz.ui.theme.Background
import com.habitz.ui.theme.Secondary

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    NavigationBar(
        containerColor = Background, // Fondo del bottom bar
        tonalElevation = 0.dp,
        modifier = Modifier
            .padding(horizontal = 15.dp)
    ) {
        val currentDestination = navController.currentBackStackEntry?.destination?.route

        bottomNavItems.forEach { screen ->
            NavigationBarItem(
                selected = currentDestination == screen.route,
                // 👇 onClick vacío, porque manejamos el click en el Box
                onClick = { },
                icon = {
                    Box(
                        modifier = Modifier
                            .size(60.dp) // tamaño del círculo
                            .background(
                                Secondary,
                                shape = CircleShape
                            )
                            .clickable( // 👈 click sin ripple
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            ) {
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.startDestinationId) { saveState = true }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = screen.icon),
                            contentDescription = screen.title,
                            tint = Background,
                            modifier = Modifier.size(28.dp)
                        )
                    }
                },
                alwaysShowLabel = false,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Background,
                    unselectedIconColor = Background,
                    indicatorColor = Color.Transparent // 👈 quitamos el óvalo por completo
                )
            )
        }
    }
}
