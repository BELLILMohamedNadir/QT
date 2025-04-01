package com.example.qt.ui.components

import android.util.Log
import android.view.ViewGroup
import android.widget.ImageView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.qt.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import pl.droidsonroids.gif.GifDrawable
import pl.droidsonroids.gif.GifImageView

@Composable
fun RobotEmotion(
    isStoryWork: MutableState<Boolean>,
    emotion: MutableState<Int>
) {
    if (!isStoryWork.value) {
        emotion.value = R.raw.qt_neutral
    }

    val previousEmotion = remember { mutableStateOf(R.raw.qt_happy) }
    val previousDrawable = remember { mutableStateOf<GifDrawable?>(null) }

    Column {
        AndroidView(
            factory = { context ->
                GifImageView(context).apply {
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    scaleType = ImageView.ScaleType.CENTER_CROP
                }
            },
            update = { gifView ->
                val currentEmotion = if (emotion.value != 0) emotion.value else R.raw.qt_talking

                if (previousEmotion.value != currentEmotion) {
                    // Recycle old drawable before setting a new one
                    previousDrawable.value?.stop()
                    previousDrawable.value?.recycle()
                    previousDrawable.value = null

                    // Set placeholder first to force refresh
                    gifView.setImageDrawable(null)

                    // Create and set new drawable
                    val newDrawable = GifDrawable(
                        gifView.context.resources.openRawResource(currentEmotion)
                    ).apply {
                        if (currentEmotion == R.raw.qt_talking) {
                            loopCount = 0 // Loop infinitely for talking GIF
                        } else {
                            loopCount = 2 // Play other GIFs twice
                        }
                        setSpeed(1f)
                        start()

//                        // Use coroutine to wait until GIF finishes (only if it's NOT talking)
//                        if (currentEmotion != R.raw.qt_talking) {
//                            CoroutineScope(Dispatchers.Main).launch {
//                                delay(duration * loopCount.toLong()) // Wait for GIF to finish
//                                emotion.value = R.raw.qt_talking // Reset or return to neutral
//                            }
//                        }
                    }
                    gifView.setImageDrawable(newDrawable)

                    // Store references
                    previousDrawable.value = newDrawable
                    previousEmotion.value = currentEmotion
                }
                if (!isStoryWork.value){
                    emotion.value = R.raw.qt_neutral
                    previousDrawable.value?.stop()
                }
            }
            ,
            modifier = Modifier
                .width(114.dp)
                .padding(bottom = 29.dp, end = 45.dp)
        )
        Spacer(modifier = Modifier.height(150.dp))
    }
}
