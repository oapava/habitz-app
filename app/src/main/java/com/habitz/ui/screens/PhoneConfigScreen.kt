package com.habitz.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.habitz.ui.theme.GrayLight
import com.habitz.ui.theme.Primary
import com.habitz.ui.theme.TextPrimary
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun PhoneConfigScreen(navController: NavHostController) {
    var phone by remember { mutableStateOf("") }
    var showOtp by remember { mutableStateOf(false) }
    var showSuccess by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GrayLight)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Configurar teléfono", color = TextPrimary)
        OutlinedTextField(
            value = phone,
            onValueChange = { phone = it.take(10) }, // maqueta: máximo 10 caracteres
            label = { Text("Número de celular") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = { showOtp = true },
            enabled = phone.isNotEmpty(),
            colors = ButtonDefaults.buttonColors(containerColor = Primary),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Enviar código SMS")
        }

        Spacer(Modifier.weight(1f))
        TextButton(onClick = { navController.popBackStack() }) {
            Text("Volver")
        }
    }

    if (showOtp) {
        OtpDialog(
            onDismiss = { showOtp = false },
            onVerify = {
                showOtp = false
                showSuccess = true
            }
        )
    }

    if (showSuccess) {
        AlertDialog(
            onDismissRequest = { showSuccess = false },
            confirmButton = {
                TextButton(onClick = {
                    showSuccess = false
                    navController.popBackStack()
                }) { Text("Cerrar") }
            },
            title = { Text("Verificación exitosa") },
            text = { Text("Tu número ha sido verificado (maqueta).") },
            shape = RoundedCornerShape(16.dp)
        )
    }
}

@Composable
private fun OtpDialog(
    onDismiss: () -> Unit,
    onVerify: (String) -> Unit
) {
    var d1 by remember { mutableStateOf("") }
    var d2 by remember { mutableStateOf("") }
    var d3 by remember { mutableStateOf("") }
    var d4 by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            Button(onClick = { onVerify(d1 + d2 + d3 + d4) }) { Text("Verificar") }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text("Cancelar") }
        },
        title = { Text("Código SMS") },
        text = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OtpBox(d1) { d1 = it }
                OtpBox(d2) { d2 = it }
                OtpBox(d3) { d3 = it }
                OtpBox(d4) { d4 = it }
            }
        },
        shape = RoundedCornerShape(16.dp)
    )
}

@Composable
private fun OtpBox(value: String, onChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = { if (it.length <= 1) onChange(it) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        modifier = Modifier.width(56.dp)
    )
}
