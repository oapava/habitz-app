package com.habitz.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.clip
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.example.habitz.R
import com.habitz.ui.shared.PrimaryIcon
import com.habitz.ui.theme.GrayLight
import com.habitz.ui.theme.Primary
import com.habitz.ui.theme.TextPrimary
import com.habitz.ui.theme.Background


@Composable
fun PhoneConfigScreen(navController: NavHostController) {
    var phone by remember { mutableStateOf("") }
    var showOtp by remember { mutableStateOf(false) }
    var showSuccess by remember { mutableStateOf(false) }

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


        item {
            Card(
                colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Configurar teléfono",
                    color = TextPrimary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp,
                    modifier = Modifier.padding(vertical = 20.dp)
                )

                OutlinedTextField(
                    value = phone,
                    onValueChange = { phone = it.take(10) },
                    placeholder = { Text("Número de celular") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,       // fondo cuando está enfocado
                        unfocusedContainerColor = Color.White,     // fondo cuando no está enfocado
                        focusedPlaceholderColor = Color.Gray,      // placeholder cuando está enfocado
                        unfocusedPlaceholderColor = Color.Gray,    // placeholder cuando no está enfocado
                        focusedBorderColor = Color.Transparent,    // borde invisible cuando está enfocado
                        unfocusedBorderColor = Color.Transparent   // borde invisible cuando no está enfocado
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp)
                        .clip(RoundedCornerShape(16.dp)) // 👈 para recortar bien el fondo
                )


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End // 👈 alinea a la derecha
                ) {
                    Button(
                        onClick = { showOtp = true },
                        enabled = true, // 👈 siempre activo
                        colors = ButtonDefaults.buttonColors(containerColor = Primary),
                        shape = RoundedCornerShape(6.dp),
                        modifier = Modifier
                            .height(48.dp) // altura estándar
                    ) {
                        Text("Enviar código SMS")
                    }
                }
            }
        }
    }

    // Modal OTP
    if (showOtp) {
        OtpDialog(
            onDismiss = { showOtp = false },
            onVerify = {
                showOtp = false
                showSuccess = true
            }
        )
    }

    // Modal éxito
    if (showSuccess) {
        SuccessDialog(
            onDismiss = { 
                showSuccess = false
                navController.popBackStack()
            }
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

    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFA7B6C2))
        ) {
            Box(modifier = Modifier.fillMaxWidth()) { //Boton cerrar
                IconButton(
                    onClick = onDismiss,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(top = 12.dp, end = 8.dp)
                ) {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = "Cerrar",
                        tint = Color(0xFFE9EDEF),
                        modifier = Modifier.size(24.dp)
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 32.dp, end = 32.dp, bottom = 32.dp, top = 48.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Código SMS",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = Background,
                        textAlign = TextAlign.Left
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Descripción
                    Text(
                        text = "Ingresa el código que llegó a el número de celular que ingresaste.",
                        fontSize = 16.sp,
                        color = Color(0xFF595959),
                        textAlign = TextAlign.Left,
                        lineHeight = 22.sp,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    //cuadros para el código
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        OtpBox(d1) { d1 = it }
                        OtpBox(d2) { d2 = it }
                        OtpBox(d3) { d3 = it }
                        OtpBox(d4) { d4 = it }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Button(
                            onClick = { onVerify(d1 + d2 + d3 + d4) },
                            colors = ButtonDefaults.buttonColors(containerColor = Primary),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.height(48.dp)
                        ) {
                            Text(
                                text = "Verificar",
                                color = Color.White,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun OtpBox(value: String, onChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = { if (it.length <= 1) onChange(it) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent
        ),
        textStyle = androidx.compose.ui.text.TextStyle(
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        ),
        modifier = Modifier
            .width(45.dp)
            .height(50.dp)
            .clip(RoundedCornerShape(8.dp))
    )
}

@Composable
private fun SuccessDialog(
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFA7B6C2))
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                IconButton(
                    onClick = onDismiss,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(top = 12.dp, end = 8.dp)
                ) {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = "Cerrar",
                        tint = Color(0xFFE9EDEF),
                        modifier = Modifier.size(24.dp)
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 32.dp, end = 32.dp, bottom = 32.dp, top = 48.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Título grande
                    Text(
                        text = "Verificación exitosa",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = Background,
                        textAlign = TextAlign.Left
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Descripción
                    Text(
                        text = "Tu número ha sido verificado correctamente.",
                        fontSize = 16.sp,
                        color = Color(0xFF595959),
                        textAlign = TextAlign.Left,
                        lineHeight = 22.sp,
                        modifier = Modifier.fillMaxWidth()
                    )

                }
            }
        }
    }
}
