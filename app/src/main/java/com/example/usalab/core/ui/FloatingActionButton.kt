package com.example.usalab.core.ui

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MediumFloatingActionButton
import androidx.compose.material3.MotionScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.usalab.R


@SuppressLint("UnusedCrossfadeTargetStateParameter")
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun FloatingActionButton(
    onClick: () -> Unit,
    deleteEnabled: Boolean,
    @DrawableRes image: Int,
) {
    MediumFloatingActionButton(
        onClick = onClick,
        shape = CircleShape,
    ) {
        Crossfade(targetState = deleteEnabled,
            animationSpec = MotionScheme.expressive().defaultEffectsSpec()
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                modifier = Modifier
                    .padding(all = 10.dp)
            )
        }
    }
}

@Preview
@Composable
fun FloatingActionButtonPreview() {
    FloatingActionButton(
        onClick = { },
        image = R.drawable.delete,
        deleteEnabled = false
    )
}