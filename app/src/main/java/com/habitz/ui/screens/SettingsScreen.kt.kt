package com.habitz.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.habitz.R
import com.habitz.ui.shared.PrimaryIcon
import com.habitz.ui.theme.Background
import com.habitz.ui.theme.GrayLight
import com.habitz.ui.theme.Primary
import com.habitz.ui.theme.TextPrimary

@Composable
fun SettingsScreen(navController: NavHostController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(GrayLight)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Header con back y logo
        item {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    PrimaryIcon(
                        ico = painterResource(id = R.drawable.backarrow),
                        onClick = { navController.popBackStack() },
                        modifier = Modifier
                            .background(
                                shape = CircleShape,
                                color = Primary
                            )
                            .size(40.dp)
                            .padding(5.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.logo_small),
                        contentDescription = "Logo de Habitz",
                        modifier = Modifier
                            .size(width = 100.dp, height = 50.dp)
                            .padding(bottom = 5.dp)
                    )
                }
            }
        }

        // Opciones configurables
        item {
            Card(
                colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Configuración",
                    color = TextPrimary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    modifier = Modifier.padding(vertical = 20.dp)
                )
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    SettingOptionRow(
                        text = "Vincular Calendario",
                        onClick = { /* acción vincular calendario */ }
                    )

                    SettingOptionRow(
                        text = "Reglas de agenda",
                        onClick = {
                            navController.navigate("agendaRules") {
                                launchSingleTop = true
                            }
                        }
                    )

                    SettingOptionRow(
                        text = "Permisos",
                        onClick = { /* acción permisos */ }
                    )

                    SettingOptionRow(
                        text = "Configurar teléfono",
                        onClick = { /* acción configurar teléfono */ }
                    )
                }
            }
        }
    }
}



/**
 * Composable reutilizable para fila de opción en settings
 */
@Composable
fun SettingOptionRow(
    text: String,
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(23.dp),
        colors = CardDefaults.cardColors(containerColor = TextPrimary),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                color = Background,
                fontWeight = FontWeight.Thin,
                fontSize = 18.sp
            )
            PrimaryIcon(
                ico = painterResource(id = R.drawable.next),
                onClick = onClick,
                modifier = Modifier
                    .background(
                        shape = CircleShape,
                        color = Primary
                    )
                    .size(25.dp)
                    .padding(5.dp)
            )
        }
    }
}

