package com.purnendu.myapps.cameraApp

import androidx.camera.core.ImageCapture
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun Camera(modifier: Modifier= Modifier) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val imageCapture = remember { ImageCapture.Builder().build() }
    val labColor = remember { mutableStateOf("LAB: N/A") }

    Box(modifier = Modifier.fillMaxSize()) {
        // Camera Preview
        AndroidView(
            factory = { ctx ->
                PreviewView(ctx).apply {
                    scaleType = PreviewView.ScaleType.FILL_CENTER
                }
            },
            modifier = Modifier.fillMaxSize(),
            update = { previewView ->
                bindCameraUseCases(previewView, imageCapture, context, lifecycleOwner)
            }
        )

        // Circular Viewfinder Overlay (added here!)
        ViewFinder()

        // Capture Button
        Button(
            onClick = { captureAndAnalyze(imageCapture, context, labColor) },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .size(50.dp)
        ) {
            Text("Capture")
        }

        // LAB Color Display
        Text(
            text = labColor.value,
            modifier = Modifier.align(Alignment.TopCenter),
            color = Color.White
        )
    }
}