package com.habitz.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habitz.R
import com.habitz.ui.shared.PrimaryButton
import com.habitz.ui.shared.PrimaryIcon
import com.habitz.ui.theme.Accent
import com.habitz.ui.theme.Background
import com.habitz.ui.theme.GrayLight
import com.habitz.ui.theme.Muted
import com.habitz.ui.theme.Primary
import com.habitz.ui.theme.TextPrimary

@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    val habits = listOf("LEER", "CORRER", "COMER SANO")

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(GrayLight)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Logo y botón principal
        item {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo de Habitz",
                    modifier = Modifier
                        .size(width = 250.dp, height = 150.dp)
                        .padding(bottom = 5.dp)
                )
                PrimaryButton(
                    text = "CREAR NUEVO HÁBITO",
                    onClick = {},
                    sizeIcon = 40
                )
            }
        }

        // Contenedor Rachas
        item {
            Card(
                shape = MaterialTheme.shapes.medium,
                colors = CardDefaults.cardColors(containerColor = Muted),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column {
                    HeaderRow("RACHAS")
                    habits.forEach { habit ->
                        HabitRow(habit = habit)
                    }
                }
            }
        }

        // Contenedor Tus Hábitos
        item {
            Card(
                shape = MaterialTheme.shapes.medium,
                colors = CardDefaults.cardColors(containerColor = Muted),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column {
                    HeaderRow("TUS HÁBITOS")
                    habits.forEach { habit ->
                        HabitRow(habit = habit, showActions = true)
                    }
                }
            }
        }
    }
}

@Composable
fun HeaderRow(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Background
            )
        )
        PrimaryIcon(
            ico = painterResource(id = R.drawable.next),
            onClick = {},
            modifier = Modifier
                .background(Primary, shape = CircleShape)
                .size(40.dp)
        )
    }
}

@Composable
fun HabitRow(habit: String, showActions: Boolean = false) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 5.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.leer),
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
            Text(
                text = habit,
                style = MaterialTheme.typography.titleLarge,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimary,
                modifier = Modifier.padding(start = 10.dp)
            )
        }

        if (showActions) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                PrimaryIcon(
                    ico = painterResource(id = R.drawable.edit),
                    onClick = {},
                    modifier = Modifier
                        .background(Primary, shape = CircleShape)
                        .size(35.dp)
                        .padding(4.dp)
                )
                PrimaryIcon(
                    ico = painterResource(id = R.drawable.detail),
                    onClick = {},
                    modifier = Modifier
                        .background(TextPrimary, shape = CircleShape) 
                        .size(35.dp)
                        .padding(4.dp)
                )
            }
        } else {
            PrimaryIcon(
                label = "10%",
                labelColor = Accent,
                onClick = {},
                modifier = Modifier
                    .background(TextPrimary, shape = CircleShape)
                    .size(35.dp)
            )
        }
    }
}
