package com.habitz.ui.screens

import android.R.attr.onClick
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ListItemDefaults.contentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.habitz.R
import com.habitz.ui.shared.PrimaryIcon
import com.habitz.ui.theme.Accent
import com.habitz.ui.theme.Background
import com.habitz.ui.theme.GrayLight
import com.habitz.ui.theme.Muted
import com.habitz.ui.theme.Primary
import com.habitz.ui.theme.TextPrimary

@Composable
fun AgendaRulesScreen(navController: NavHostController) {
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
                        onClick = {navController.popBackStack() },
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
                //shape = MaterialTheme.shapes.large,
                //colors = CardDefaults.cardColors(containerColor = TextPrimary),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Reglas de Agenda",
                    color = TextPrimary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    modifier = Modifier
                        .padding(vertical = 20.dp)
                )
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {

                    AgendaRulesOptionRow(
                        text = "RANGO DE HORARIO",
                        onClick = { /* acción vincular calendario */ }

                    ){
                        var text1 by remember { mutableStateOf("08") }
                        var text2 by remember { mutableStateOf("30") }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            // Texto a la izquierda
                            Text(
                                text = "Hora Inicio",
                                color = TextPrimary,
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp
                            )

                            // Inputs agrupados a la derecha
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(8.dp), // espacio entre inputs
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                StyledInput(
                                    value = text1,
                                    onValueChange = { text1 = it }
                                )
                                StyledInput(
                                    value = text2,
                                    onValueChange = { text2 = it }
                                )
                            }
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            // Texto a la izquierda
                            Text(
                                text = "Hora Fin",
                                color = TextPrimary,
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp
                            )

                            // Inputs agrupados a la derecha
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(8.dp), // espacio entre inputs
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                StyledInput(
                                    value = text1,
                                    onValueChange = { text1 = it }
                                )
                                StyledInput(
                                    value = text2,
                                    onValueChange = { text2 = it }
                                )
                            }
                        }

                    }

                    AgendaRulesOptionRow(
                        text = "INTERVALOS",
                        onClick = { /* acción vincular calendario */ }

                    ){
                        var text1 by remember { mutableStateOf("08") }
                        var text2 by remember { mutableStateOf("30") }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            // Texto a la izquierda
                            Text(
                                text = "Intervalos mínimos",
                                color = TextPrimary,
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp
                            )

                            // Columna a la derecha (Texto arriba + Row con inputs abajo)
                            Column(
                                horizontalAlignment = Alignment.Start // 👈 cambia a Start
                            ) {
                                Text(
                                    text = "Minutos",
                                    color = Background,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 14.sp,
                                    modifier = Modifier.padding(bottom = 4.dp)
                                )

                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    StyledInput(
                                        value = text1,
                                        onValueChange = { text1 = it }
                                    )
                                    StyledInput(
                                        value = text2,
                                        onValueChange = { text2 = it }
                                    )
                                }
                            }
                        }
                    }

                    AgendaRulesOptionRow(
                        text = "DÍAS",
                        onClick = { /* acción vincular calendario */ }

                    ){
                        // Variables de estado individuales para cada día
                        var lunChecked by remember { mutableStateOf(false) }
                        var marChecked by remember { mutableStateOf(false) }
                        var mieChecked by remember { mutableStateOf(false) }
                        var jueChecked by remember { mutableStateOf(false) }
                        var vieChecked by remember { mutableStateOf(false) }
                        var sabChecked by remember { mutableStateOf(false) }
                        var domChecked by remember { mutableStateOf(false) }
                        
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            ReusableCheckbox(
                                checked = lunChecked,
                                onCheckedChange = { lunChecked = it },
                                label = "LUN",
                                size = 32.dp,
                                checkedColor = Primary,
                                uncheckedColor = Color.Black,
                                checkmarkColor = Muted
                            )

                            ReusableCheckbox(
                                checked = marChecked,
                                onCheckedChange = { marChecked = it },
                                label = "MAR",
                                size = 32.dp,
                                checkedColor = Primary,
                                uncheckedColor = Color.Black,
                                checkmarkColor = Muted
                            )

                            ReusableCheckbox(
                                checked = mieChecked,
                                onCheckedChange = { mieChecked = it },
                                label = "MIE",
                                size = 32.dp,
                                checkedColor = Primary,
                                uncheckedColor = Color.Black,
                                checkmarkColor = Muted
                            )

                            ReusableCheckbox(
                                checked = jueChecked,
                                onCheckedChange = { jueChecked = it },
                                label = "JUE",
                                size = 32.dp,
                                checkedColor = Primary,
                                uncheckedColor = Color.Black,
                                checkmarkColor = Muted
                            )

                            ReusableCheckbox(
                                checked = vieChecked,
                                onCheckedChange = { vieChecked = it },
                                label = "VIE",
                                size = 32.dp,
                                checkedColor = Primary,
                                uncheckedColor = Color.Black,
                                checkmarkColor = Muted
                            )

                            ReusableCheckbox(
                                checked = sabChecked,
                                onCheckedChange = { sabChecked = it },
                                label = "SAB",
                                size = 32.dp,
                                checkedColor = Primary,
                                uncheckedColor = Color.Black,
                                checkmarkColor = Muted
                            )

                            ReusableCheckbox(
                                checked = domChecked,
                                onCheckedChange = { domChecked = it },
                                label = "DOM",
                                size = 32.dp,
                                checkedColor = Primary,
                                uncheckedColor = Color.Black,
                                checkmarkColor = Muted
                            )


                        }

                    }

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.End
                    ) {
                        Button(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Primary,
                                contentColor = Background
                            ),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .height(50.dp)
                                .width(120.dp)
                        ) {
                            Text(
                                text = "Guardar",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Background
                            )
                        }
                    }


                }
            }
        }
    }
}

/**
 * Composable reutilizable para fila de opción en settings
 */
@Composable
fun AgendaRulesOptionRow(
    text: String,
    onClick: () -> Unit,
    content: @Composable () -> Unit = {}
) {
    Card(
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(containerColor = Muted),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column( // 👈 para que el texto y los hijos se acomoden en vertical
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // título
            Text(
                text = text,
                color = Background,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            content()
        }
    }
}


@Composable
fun StyledInput(
    value: String,
    onValueChange: (String) -> Unit
) {
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        textStyle = LocalTextStyle.current.copy(
            color = Color(0xFF4F9D92), // color del texto (ejemplo verde azulado)
            textAlign = TextAlign.Center // texto centrado
        ),
        modifier = Modifier
            .size(40.dp) // ancho y alto fijo
            .background(Color.White, shape = RoundedCornerShape(12.dp)) // fondo blanco con esquinas redondeadas
            .border(
                width = 2.dp,
                color = Color.DarkGray,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(4.dp), // espacio interno
        decorationBox = { innerTextField ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                innerTextField()
            }
        }
    )
}

@Composable
fun ReusableCheckbox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    size: Dp = 32.dp, // tamaño del checkbox
    checkedColor: Color = MaterialTheme.colorScheme.primary,
    uncheckedColor: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
    checkmarkColor: Color = Color.White,
    labelColor: Color = MaterialTheme.colorScheme.onSurface,
    labelSize: TextUnit = 14.sp
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        // Checkbox escalado
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            modifier = Modifier.size(size),
            colors = CheckboxDefaults.colors(
                checkedColor = checkedColor,
                uncheckedColor = uncheckedColor,
                checkmarkColor = checkmarkColor
            )
        )

        // Label inferior
        Text(
            text = label,
            color = labelColor,
            fontSize = labelSize,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}


