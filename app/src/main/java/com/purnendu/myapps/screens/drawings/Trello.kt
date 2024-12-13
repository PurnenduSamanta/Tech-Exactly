package com.purnendu.myapps.screens.drawings

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Trello(modifier: Modifier = Modifier)
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

        drawRoundRect(
            cornerRadius = CornerRadius(x = 40f, y = 40f),
            color = Color.Blue, size = Size(width = width,height=height)
        )

        drawRoundRect(
            topLeft = Offset(x=width*0.2f,y=height*0.2f),
            cornerRadius = CornerRadius(x = 15f, y = 15f),
            color = Color.White, size = Size(width = width*0.3f,height=height*.55f)
        )

        drawRoundRect(
            topLeft = Offset(x=width*0.6f,y=height*0.2f),
            cornerRadius = CornerRadius(x = 15f, y = 15f),
            color = Color.White, size = Size(width = width*0.3f,height=height*.4f)
        )


    }

}
