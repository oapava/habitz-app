package com.habitz.ui.shared

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.habitz.ui.theme.Accent
import com.habitz.ui.theme.Primary
import com.habitz.ui.theme.Secondary
import com.habitz.ui.theme.TextPrimary

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    sizeIcon: Int,
    modifier: Modifier = Modifier,
    onIconClick: (() -> Unit)? = null
) {
    Card(
        onClick = onClick,
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = Accent,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 8.dp)
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                ),
                color = TextPrimary
            )
            PrimaryIcon(
                ico = painterResource(id = com.example.habitz.R.drawable.plus),
                onClick = { onIconClick?.invoke() },
                modifier = Modifier
                    .background(
                        shape = CircleShape,
                        color = Primary
                    )
                    .size(sizeIcon.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PrimaryButtonPreview() {
    MaterialTheme {
        PrimaryButton(
            text = "CREAR UN NUEVO HÁBITO",
            onClick = {},
            sizeIcon = 45
        )
    }
}
