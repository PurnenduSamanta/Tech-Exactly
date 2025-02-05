package com.purnendu.myapps.cameraApp

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.util.Log
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.compose.runtime.MutableState
import androidx.core.content.ContextCompat
import java.io.File
import kotlin.math.pow

fun captureAndAnalyze(
    imageCapture: ImageCapture,
    context: Context,
    labColor: MutableState<String>
) {
    val outputFile = File.createTempFile("camera_capture", ".jpg", context.cacheDir)
    val outputOptions = ImageCapture.OutputFileOptions.Builder(outputFile).build()

    imageCapture.takePicture(
        outputOptions,
        ContextCompat.getMainExecutor(context),
        object : ImageCapture.OnImageSavedCallback {
            override fun onImageSaved(output: ImageCapture.OutputFileResults) {
                val bitmap = android.graphics.BitmapFactory.decodeFile(outputFile.absolutePath)
                val centerColor = getCenterPixelColor(bitmap)
                val lab = rgbToLab(centerColor)
                labColor.value = "LAB: (${lab[0]}, ${lab[1]}, ${lab[2]})"
            }

            override fun onError(ex: ImageCaptureException) {
                Log.e("Camera", "Capture failed: ${ex.message}", ex)
            }
        }
    )
}


private fun getCenterPixelColor(bitmap: Bitmap): Int {
    val x = bitmap.width / 2
    val y = bitmap.height / 2
    return bitmap.getPixel(x, y)
}

private fun rgbToLab(color: Int): FloatArray {
    val red = Color.red(color)
    val green = Color.green(color)
    val blue = Color.blue(color)

    // Convert RGB to XYZ
    val (x, y, z) = rgbToXyz(red, green, blue)

    // Convert XYZ to LAB
    return xyzToLab(x, y, z)
}

private fun rgbToXyz(r: Int, g: Int, b: Int): Triple<Double, Double, Double> {
    var red = r / 255.0
    var green = g / 255.0
    var blue = b / 255.0

    // Apply gamma correction for sRGB
    red = if (red > 0.04045) ((red + 0.055) / 1.055).pow(2.4) else red / 12.92
    green = if (green > 0.04045) ((green + 0.055) / 1.055).pow(2.4) else green / 12.92
    blue = if (blue > 0.04045) ((blue + 0.055) / 1.055).pow(2.4) else blue / 12.92

    // Convert to XYZ using sRGB D65 matrix
    val x = red * 0.4124564 + green * 0.3575761 + blue * 0.1804375
    val y = red * 0.2126729 + green * 0.7151522 + blue * 0.0721750
    val z = red * 0.0193339 + green * 0.1191920 + blue * 0.9503041

    return Triple(x * 100.0, y * 100.0, z * 100.0)
}

private fun xyzToLab(x: Double, y: Double, z: Double): FloatArray {
    // D65 reference white point
    val refX = 95.047
    val refY = 100.000
    val refZ = 108.883

    var varX = x / refX
    var varY = y / refY
    var varZ = z / refZ

    varX = if (varX > 0.008856) varX.pow(1.0 / 3.0) else (7.787 * varX) + (16.0 / 116.0)
    varY = if (varY > 0.008856) varY.pow(1.0 / 3.0) else (7.787 * varY) + (16.0 / 116.0)
    varZ = if (varZ > 0.008856) varZ.pow(1.0 / 3.0) else (7.787 * varZ) + (16.0 / 116.0)

    val l = (116.0 * varY) - 16.0
    val a = 500.0 * (varX - varY)
    val b = 200.0 * (varY - varZ)

    return floatArrayOf(l.toFloat(), a.toFloat(), b.toFloat())
}