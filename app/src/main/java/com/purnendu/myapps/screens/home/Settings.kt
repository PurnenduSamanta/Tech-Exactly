package com.purnendu.myapps.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun Settings(modifier: Modifier = Modifier) {

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center)
    {
        Text("Settings page", color = Color.Green, fontSize = 25.sp)
    }
}