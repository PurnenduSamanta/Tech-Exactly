package com.purnendu.myapps.cameraApp

import android.content.Context
import android.util.Log
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.core.content.ContextCompat

 fun bindCameraUseCases(
     previewView: PreviewView,
     imageCapture: ImageCapture,
     context: Context,
     lifecycleOwner: androidx.lifecycle.LifecycleOwner
) {
     val cameraProviderFuture = ProcessCameraProvider.getInstance(context)
     cameraProviderFuture.addListener({
         val cameraProvider = cameraProviderFuture.get()
         val preview = Preview.Builder().build().also {
             it.surfaceProvider = previewView.surfaceProvider
         }

         try {
             cameraProvider.unbindAll()
             cameraProvider.bindToLifecycle(
                 lifecycleOwner,
                 CameraSelector.DEFAULT_BACK_CAMERA,
                 preview,
                 imageCapture
             )
         } catch (e: Exception) {
             Log.e("Camera", "Failed to bind camera use cases", e)
         }
     }, ContextCompat.getMainExecutor(context))
}