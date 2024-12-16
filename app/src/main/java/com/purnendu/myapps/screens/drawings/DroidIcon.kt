package com.purnendu.myapps.screens.drawings

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp

@Composable
fun DroidIcon(modifier: Modifier = Modifier)
{

    Canvas(
        modifier = Modifier
            .background(color = Color.White)
            .size(200.dp)
            .padding(10.dp)
    )
    {
        val height = size.height
        val width = size.width

        drawArc(
            color = Color(0xFF4CAF50),
            startAngle = 0f,
            sweepAngle = -180f,
            useCenter = true,
            topLeft = Offset(x = width * .2f, y = height * .75f),
            size = Size(width = width * .6f, height = height * .5f)
        )

        // draw left eye
        drawCircle(
            radius = width.times(.04f),
            color = Color.White,
            center = Offset(width.times(.38f), height.times(.88f))
        )

        // draw right eye
        drawCircle(
            radius = width.times(.04f),
            color = Color.White,
            center = Offset(width.times(.62f), height.times(.88f)),
        )

        // draw left antennae
        drawLine(
            color = Color(0xFF4CAF50),
            start = Offset(x = width * .15f, y = height * .75f),
            end = Offset(x = width * .25f, y = height * .85f),
            strokeWidth = 15f,
            cap = StrokeCap.Round
        )

        // draw right antennae
        drawLine(
            color = Color(0xFF4CAF50),
            start = Offset(x = width * .85f, y = height * .75f),
            end = Offset(x = width * .75f, y = height * .85f),
            strokeWidth = 15f,
            cap = StrokeCap.Round
        )

    }

}