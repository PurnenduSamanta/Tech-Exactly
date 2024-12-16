package com.purnendu.myapps.screens.drawings

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun SpotifyIcon(modifier: Modifier = Modifier) {

    Canvas(
        modifier = Modifier
            .background(color = Color.White)
            .size(200.dp)
            .padding(10.dp)
    )
    {
        val height = size.height
        val width = size.width

        // draw green background
        drawCircle(
            color = Color(0xFF1ed760)
        )

        // draw black borderline
        drawCircle(
            color = Color.Black,
            style = Stroke(width = 25f)
        )


      /*  drawPoints(
            points = listOf(
                Offset(x = width * .18f, y = height * .35f),
                Offset(x = width * .17f, y = height * .35f),
                Offset(x = width * .46f, y = height * .21f),
                Offset(x = width * .81f, y = height * .38f),

                Offset(width * .28f, height * .50f),
                Offset(width * .27f, height * .50f),
                Offset(width * .45f, height * .43f),
                Offset(width * .73f, height * .55f),


                Offset(width * .33f, height * .67f),
                Offset(width * .33f, height * .67f),
                Offset(width * .45f, height * .62f),
                Offset(width * .67f, height * .72f),


            ),
            pointMode = PointMode.Points,
            color = Color.Red,
            strokeWidth = 20f,
            cap = StrokeCap.Round
        )*/

        // draw the three independent lines using Bezier Curves
        drawPath(
            color = Color.Black,
            style = Stroke(width = 18f, cap = StrokeCap.Round),
            path = Path().apply {
                // starting point
                moveTo(
                    x = width * .18f,
                    y = height * .35f
                )

                cubicTo(
                    width.times(.17f),
                    height.times(.35f),

                    width.times(.46f),
                    height.times(.21f),

                    width.times(.81f),
                    height.times(.38f)
                )


                // reset path painter for second line
                moveTo(
                    width.times(.28f),
                    height.times(.50f),
                )

                cubicTo(
                    width.times(.27f),
                    height.times(.50f),
                    width.times(.45f),
                    height.times(.43f),
                    width.times(.73f),
                    height.times(.55f)
                )


                // reset path painter for third line
                moveTo(
                    width.times(.33f),
                    height.times(.67f),
                )

                cubicTo(
                    width.times(.33f),
                    height.times(.67f),
                    width.times(.45f),
                    height.times(.62f),
                    width.times(.67f),
                    height.times(.72f)
                )


            }
        )


    }

}