package com.habitz.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.habitz.R
import com.habitz.ui.shared.PrimaryIcon
import com.habitz.ui.theme.GrayLight
import com.habitz.ui.theme.Primary
import com.habitz.ui.theme.TextPrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateHabitScreen(navController: NavHostController) {
    var habitName by remember { mutableStateOf("") }
    var habitDesc by remember { mutableStateOf("") }
    var startDate by remember { mutableStateOf("") }
    var endDate by remember { mutableStateOf("") }

    var periodicityNum by remember { mutableStateOf("1") }
    var periodicityUnit by remember { mutableStateOf("Semana") }
    var periodicityNumExpanded by remember { mutableStateOf(false) }
    var periodicityUnitExpanded by remember { mutableStateOf(false) }

    var durationNum by remember { mutableStateOf("1") }
    var durationUnit by remember { mutableStateOf("Semana") }
    var durationNumExpanded by remember { mutableStateOf(false) }
    var durationUnitExpanded by remember { mutableStateOf(false) }

    var everyDay by remember { mutableStateOf(false) }
    var motivation by remember { mutableStateOf(false) }

    // Días de la semana
    val weekDays = listOf("LUN", "MAR", "MIE", "JUE", "VIE", "SÁB", "DOM")
    var selectedDays by remember { mutableStateOf(weekDays.toSet()) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(GrayLight)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Header con back y logo
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                PrimaryIcon(
                    ico = painterResource(id = R.drawable.backarrow),
                    onClick = { navController.popBackStack() },
                    modifier = Modifier
                        .background(shape = CircleShape, color = Primary)
                        .size(40.dp)
                        .padding(5.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.logo_small),
                    contentDescription = "Logo de Habitz",
                    modifier = Modifier.size(width = 100.dp, height = 50.dp)
                )
            }
        }

        // Título
        item {
            Text(
                text = "Crear Hábito",
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                color = TextPrimary
            )
        }

        // Nombre hábito y Descripción
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.leer),
                    contentDescription = "Ícono del hábito",
                    modifier = Modifier
                        .weight(0.25f)
                        .size(85.dp)
                )
                Column(
                    modifier = Modifier.weight(0.75f),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    OutlinedTextField(
                        value = habitName,
                        onValueChange = { habitName = it },
                        placeholder = { Text("Nombre hábito", color = Color.Gray) },
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent,
                            disabledBorderColor = Color.Transparent,
                            errorBorderColor = Color.Transparent,
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White, RoundedCornerShape(14.dp))
                    )
                    OutlinedTextField(
                        value = habitDesc,
                        onValueChange = { habitDesc = it },
                        placeholder = { Text("Descripción hábito", color = Color.Gray) },
                        maxLines = 4,
                        minLines = 3,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent,
                            disabledBorderColor = Color.Transparent,
                            errorBorderColor = Color.Transparent,
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .background(Color.White, RoundedCornerShape(14.dp))
                    )
                }
            }
        }

        // Fechas
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Fecha Ini./Fin.", 
                    fontWeight = FontWeight.Normal,
                    color = TextPrimary,
                    modifier = Modifier.weight(1f)
                )
                OutlinedTextField(
                    value = startDate,
                    onValueChange = { startDate = it },
                    placeholder = { Text("dd/mm/aaaa", color = Color.Gray) },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .weight(1.2f)
                        .height(56.dp)
                        .background(Color.White, RoundedCornerShape(12.dp))
                )
                OutlinedTextField(
                    value = endDate,
                    onValueChange = { endDate = it },
                    placeholder = { Text("dd/mm/aaaa", color = Color.Gray) },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .weight(1.2f)
                        .height(56.dp)
                        .background(Color.White, RoundedCornerShape(12.dp))
                )
            }
        }

        // Periodicidad
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Periodicidad", 
                    fontWeight = FontWeight.Normal,
                    color = TextPrimary,
                    modifier = Modifier.weight(1.5f)
                )
                
                // Dropdown para número
                ExposedDropdownMenuBox(
                    expanded = periodicityNumExpanded,
                    onExpandedChange = { periodicityNumExpanded = !periodicityNumExpanded },
                    modifier = Modifier.weight(1f)
                ) {
                    OutlinedTextField(
                        value = periodicityNum,
                        onValueChange = {},
                        readOnly = true,
                        placeholder = { Text("1", color = Color.Gray) },
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = periodicityNumExpanded) },
                        modifier = Modifier
                            .menuAnchor()
                            .background(Color.White, RoundedCornerShape(12.dp))
                    )
                    ExposedDropdownMenu(
                        expanded = periodicityNumExpanded,
                        onDismissRequest = { periodicityNumExpanded = false }
                    ) {
                        listOf("1", "2", "3", "4", "5", "6", "7").forEach { number ->
                            DropdownMenuItem(
                                text = { Text(number) },
                                onClick = {
                                    periodicityNum = number
                                    periodicityNumExpanded = false
                                }
                            )
                        }
                    }
                }
                
                // Dropdown para unidad
                ExposedDropdownMenuBox(
                    expanded = periodicityUnitExpanded,
                    onExpandedChange = { periodicityUnitExpanded = !periodicityUnitExpanded },
                    modifier = Modifier.weight(1.5f)
                ) {
                    OutlinedTextField(
                        value = periodicityUnit,
                        onValueChange = {},
                        readOnly = true,
                        placeholder = { Text("Semana", color = Color.Gray) },
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = periodicityUnitExpanded) },
                        modifier = Modifier
                            .menuAnchor()
                            .background(Color.White, RoundedCornerShape(12.dp))
                    )
                    ExposedDropdownMenu(
                        expanded = periodicityUnitExpanded,
                        onDismissRequest = { periodicityUnitExpanded = false }
                    ) {
                        listOf("Día", "Semana", "Mes", "Año").forEach { unit ->
                            DropdownMenuItem(
                                text = { Text(unit) },
                                onClick = {
                                    periodicityUnit = unit
                                    periodicityUnitExpanded = false
                                }
                            )
                        }
                    }
                }
            }
        }

        // Días de la semana
        item {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Días de la semana", fontWeight = FontWeight.Normal, color = TextPrimary)
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text("Todos los días", fontSize = 14.sp, color = TextPrimary)
                        Switch(
                            checked = everyDay, 
                            onCheckedChange = { everyDay = it },
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = Color.White,
                                checkedTrackColor = colorResource(id = com.example.habitz.R.color.switch_active),
                                uncheckedThumbColor = Color.White,
                                uncheckedTrackColor = Color.Gray
                            )
                        )
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    weekDays.forEach { day ->
                        Checkbox(
                            checked = selectedDays.contains(day),
                            onCheckedChange = {
                                selectedDays = if (it) {
                                    selectedDays + day
                                } else {
                                    selectedDays - day
                                }
                            },
                            colors = CheckboxDefaults.colors(checkedColor = Primary)
                        )
                    }
                }
                // Etiquetas de días
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    weekDays.forEach { day ->
                        Text(day, fontSize = 12.sp, color = TextPrimary)
                    }
                }
            }
        }

        // Duración de la actividad
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Duración de la actividad (Hábito)", 
                    fontWeight = FontWeight.Normal,
                    color = TextPrimary,
                    modifier = Modifier.weight(1.5f)
                )

                ExposedDropdownMenuBox(
                    expanded = durationNumExpanded,
                    onExpandedChange = { durationNumExpanded = !durationNumExpanded },
                    modifier = Modifier.weight(1f)
                ) {
                    OutlinedTextField(
                        value = durationNum,
                        onValueChange = {},
                        readOnly = true,
                        placeholder = { Text("1", color = Color.Gray) },
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = durationNumExpanded) },
                        modifier = Modifier
                            .menuAnchor()
                            .height(56.dp)
                            .background(Color.White, RoundedCornerShape(12.dp))
                    )
                    ExposedDropdownMenu(
                        expanded = durationNumExpanded,
                        onDismissRequest = { durationNumExpanded = false }
                    ) {
                        listOf("2", "3", "4", "5", "10", "20", "30").forEach { number ->
                            DropdownMenuItem(
                                text = { Text(number) },
                                onClick = {
                                    durationNum = number
                                    durationNumExpanded = false
                                }
                            )
                        }
                    }
                }

                ExposedDropdownMenuBox(
                    expanded = durationUnitExpanded,
                    onExpandedChange = { durationUnitExpanded = !durationUnitExpanded },
                    modifier = Modifier.weight(1.5f)
                ) {
                    OutlinedTextField(
                        value = durationUnit,
                        onValueChange = {},
                        readOnly = true,
                        placeholder = { Text("Semana", color = Color.Gray) },
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = durationUnitExpanded) },
                        modifier = Modifier
                            .menuAnchor()
                            .height(56.dp)
                            .background(Color.White, RoundedCornerShape(12.dp))
                    )
                    ExposedDropdownMenu(
                        expanded = durationUnitExpanded,
                        onDismissRequest = { durationUnitExpanded = false }
                    ) {
                        listOf("Dia", "Semana", "Mes", "Año").forEach { unit ->
                            DropdownMenuItem(
                                text = { Text(unit) },
                                onClick = {
                                    durationUnit = unit
                                    durationUnitExpanded = false
                                }
                            )
                        }
                    }
                }
            }
        }

        // Mensaje motivacional
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Mensaje de motivación en la alarma", fontWeight = FontWeight.Normal, color = TextPrimary)
                Switch(
                    checked = motivation, 
                    onCheckedChange = { motivation = it },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.White,
                        checkedTrackColor = colorResource(id = com.example.habitz.R.color.switch_active),
                        uncheckedThumbColor = Color.White,
                        uncheckedTrackColor = Color.Gray
                    )
                )
            }
        }

        // Botones
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.End)
            ) {
                Button(
                    onClick = { navController.popBackStack() },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF4B860)),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.width(120.dp)
                ) {
                    Text("Cancelar", color = Color.White)
                }
                Button(
                    onClick = { navController.popBackStack()  },
                    colors = ButtonDefaults.buttonColors(containerColor = Primary),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.width(120.dp)
                ) {
                    Text("Guardar", color = Color.White)
                }
            }
        }
    }
}
