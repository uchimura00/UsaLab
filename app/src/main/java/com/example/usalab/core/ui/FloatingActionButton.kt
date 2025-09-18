package com.example.usalab.core.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BorderColor
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.MediumFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun FloatingActionButton(onClick: () -> Unit) {
    MediumFloatingActionButton(
        onClick = onClick,
        shape = CircleShape,
    ) {
        Icon(
            imageVector = Icons.Filled.BorderColor,
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.padding(all = 10.dp),
        )
    }
}

@Preview
@Composable
fun FloatingActionButtonPreview() {
    FloatingActionButton(
        onClick = { },
    )
}