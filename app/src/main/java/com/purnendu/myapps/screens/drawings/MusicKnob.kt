package com.purnendu.myapps.screens.drawings

import android.view.MotionEvent.ACTION_DOWN
import android.view.MotionEvent.ACTION_MOVE
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import com.purnendu.myapps.R
import kotlin.math.PI
import kotlin.math.atan2

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MusicKnob(
    modifier: Modifier = Modifier,
    onValueChange: (Float) -> Unit
)
{

    var rotation = remember { mutableFloatStateOf(0f) }

    var touchX = remember { mutableFloatStateOf(0f) }

    var touchY = remember { mutableFloatStateOf(0f) }

    var centerX = remember { mutableFloatStateOf(0f) }

    var centerY = remember { mutableFloatStateOf(0f) }


    println(rotation.floatValue)


    Image(
        painter = painterResource(R.drawable.music_knob),
        contentDescription = "musicKnob",
        modifier = modifier
            .fillMaxSize()
            .onGloballyPositioned {
                val windowBounds = it.boundsInWindow()
                centerX.floatValue=windowBounds.size.width/2f
                centerY.floatValue=windowBounds.size.height/2f
            }
            .pointerInteropFilter{
                event->
                touchX.floatValue = event.x
                touchY.floatValue = event.y

                val angle = atan2( centerY.floatValue - touchY.floatValue,centerX.floatValue - touchX.floatValue) * (180f / PI).toFloat()

                when(event.action)
                {
                   ACTION_DOWN,
                   ACTION_MOVE ->{

                     /*  val fixedAngle = if (angle in -180f..0f) {
                           360f + angle
                       } else {
                           angle
                       }*/

                       rotation.floatValue = angle

                       true

                   }
                    else -> false

                }
            }
            .rotate(rotation.floatValue)

    )
}