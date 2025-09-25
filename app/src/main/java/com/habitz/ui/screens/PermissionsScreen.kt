package com.habitz.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

import com.habitz.ui.theme.Primary
import com.habitz.ui.theme.TextPrimary
import com.habitz.ui.theme.GrayLight

@Composable
fun PermissionsScreen(navController: NavHostController) {
    // Estados locales (maqueta, no conectan a permisos reales)
    var readCal by remember { mutableStateOf(false) }
    var writeCal by remember { mutableStateOf(false) }
    var whatsapp by remember { mutableStateOf(false) }
    var calls by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GrayLight)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Permisos", color = TextPrimary, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(8.dp))

        PermissionRow("Leer calendario", readCal) { readCal = it }
        PermissionRow("Crear / Editar eventos", writeCal) { writeCal = it }
        PermissionRow("Whatsapp (preferencia)", whatsapp) { whatsapp = it }
        PermissionRow("Llamadas", calls) { calls = it }

        Spacer(Modifier.weight(1f))
        Button(
            onClick = { navController.popBackStack() },
            colors = ButtonDefaults.buttonColors(containerColor = Primary),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar y volver")
        }
    }
}

@Composable
private fun PermissionRow(
    title: String,
    checked: Boolean,
    onToggle: (Boolean) -> Unit
) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        tonalElevation = 2.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 14.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(title)
            Switch(checked = checked, onCheckedChange = onToggle)
        }
    }
}
