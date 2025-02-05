package com.purnendu.myapps.cameraApp

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ViewFinder(modifier: Modifier = Modifier)
{
    val radius = 100.dp // Adjust based on your needs

    Canvas(modifier = Modifier.fillMaxSize()) {
        // Draw semi-transparent background
        drawRect(color = Color.Gray.copy(alpha = 0.5f))

        // Cut out a transparent circle
        drawCircle(
            color = Color.Transparent,
            radius = radius.toPx(),
            blendMode = BlendMode.Clear
        )
    }
}