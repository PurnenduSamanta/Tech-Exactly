package com.purnendu.myapps.screens.drawings

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.dp


@Composable
fun YouTube()
{
    Canvas(
        modifier = Modifier
            .size(200.dp)
            .border(width = 1.dp, color = Color.Green)
            .padding(8.dp)
            .border(width = 1.dp, color = Color.Blue))
    {
        val height = size.height
        val width = size.width

        Log.d("height", (height * .65f).toString())
        Log.d("width", width.toString())

        // draw red rectangular frame for the red YouTube outline
        drawRoundRect(
            color = Color.Red,
            cornerRadius = CornerRadius(x = 65f, y = 65f),
            size = Size(width, height * .65f),
        )

        // draw triangular path with white color
        drawPath(color = Color.White, path = Path().apply {
            moveTo(width * .35f, height * .18f)
            lineTo(width * .75f, height * .33f)
            lineTo(width * .35f, height * .48f)
            close()
        })
    }
}