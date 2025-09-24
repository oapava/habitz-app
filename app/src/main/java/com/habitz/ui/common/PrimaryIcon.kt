package com.habitz.ui.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.habitz.R
import com.habitz.ui.theme.Accent
import com.habitz.ui.theme.Primary
import com.habitz.ui.theme.TextPrimary

@Composable
fun PrimaryIcon(
    onClick: () -> Unit,
    ico: Painter? = null,
    label: String? = null,
    labelColor: Color? = MaterialTheme.colorScheme.onPrimary,
    modifier: Modifier = Modifier
) {
    if (ico != null) {
        Icon(
            painter = ico,
            contentDescription = "Icono",
            tint = MaterialTheme.colorScheme.onPrimary,
            modifier = modifier
        )
    } else if (label != null) {
        Box(
            modifier = modifier
                .size(40.dp)
                .background(
                    color = TextPrimary,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center // centra el texto dentro del círculo
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = labelColor ?: MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PrimaryIconPreview() {
    MaterialTheme {
        PrimaryIcon(
            //ico = painterResource(id = R.drawable.plus),
            label = "10%",
            labelColor = Accent,
            onClick = {},
            modifier = Modifier
                    .background(
                        shape = CircleShape,
                        color = TextPrimary
                    )
                .size(35.dp)
        )
    }
}