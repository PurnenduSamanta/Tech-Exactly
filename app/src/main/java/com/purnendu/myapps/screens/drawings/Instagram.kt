package com.purnendu.myapps.screens.drawings

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun Instagram(modifier: Modifier = Modifier)
{
    val gradientBrush = Brush.horizontalGradient(colors = listOf(Color(0xFF673AB7), Color(0xFFF44336), Color(0xFFFF9800)))
    Canvas(
        modifier = Modifier
            .size(250.dp)
            .background(color = Color.White)
            .padding(20.dp)
    )
    {
        val borderWidth = 15.dp.toPx() // Convert dp to pixels

        drawRoundRect(
            brush = gradientBrush,
            size = size.copy(width = size.width , height = size.height ),
            cornerRadius = CornerRadius(50f, 50f),
            style = Stroke(width =  borderWidth)
        )

        drawCircle(
            radius = 80f,
            brush = gradientBrush,
            style = Stroke(width =  20.dp.toPx())
        )

        drawCircle(
            radius = 15f,
            color = Color(0xFFF44336),
            style = Fill,
            center = Offset(x = (size.width * 0.8f), y = (size.height * .15f))
        )

    }

}