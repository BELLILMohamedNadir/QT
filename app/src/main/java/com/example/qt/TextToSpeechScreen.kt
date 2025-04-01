package com.example.qt

import android.annotation.SuppressLint
import android.media.*
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.widget.Toast
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.*
import java.util.*
import kotlin.random.Random

@Composable
fun TextToSpeechScreen(textToSpeech: TextToSpeech) {
    var text by remember { mutableStateOf("Hello, how are you?") }
    val context = LocalContext.current
    var isSpeaking by remember { mutableStateOf(false) }
    var speechSpeed by remember { mutableStateOf(0.2f) }  // Speed-based movement
    var speechVolume by remember { mutableStateOf(20f) }  // Volume-based movement

    // Dynamic mouth animation: Adjusts speed and size based on speech
    val mouthHeight by animateFloatAsState(
        targetValue = if (isSpeaking) (speechVolume * 2) else 20f,  // Adjust based on volume
        animationSpec = tween((speechSpeed * 200).toInt(), easing = LinearEasing),
        label = "MouthAnimation"
    )

    // CoroutineScope for recording volume
    val coroutineScope = rememberCoroutineScope()

    // Speech Listener
    LaunchedEffect(textToSpeech) {
        textToSpeech.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
            override fun onStart(utteranceId: String?) {
                isSpeaking = true
                speechSpeed = 0.3f + Random.nextFloat() * 0.4f // Random speech variation
                coroutineScope.launch { captureAudio { volume -> speechVolume = volume } }
            }

            override fun onDone(utteranceId: String?) {
                isSpeaking = false
            }

            override fun onError(utteranceId: String?) {
                isSpeaking = false
            }
        })
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        BasicTextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        Button(
            onClick = {
                if (text.isNotEmpty()) {
                    textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, "utteranceId")
                } else {
                    Toast.makeText(context, "Enter some text", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Speak")
        }

        // Draw Simulated Talking Mouth
        MouthCanvas(mouthHeight)
    }
}

// 🎤 Capture Audio & Extract Volume (Runs in Background)
@SuppressLint("MissingPermission")
suspend fun captureAudio(onVolumeMeasured: (Float) -> Unit) {
    val bufferSize = AudioRecord.getMinBufferSize(44100, AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT)
    val audioRecord = AudioRecord(
        MediaRecorder.AudioSource.VOICE_RECOGNITION, 44100,
        AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT, bufferSize
    )

    val buffer = ShortArray(bufferSize / 2)
    audioRecord.startRecording()

    while (audioRecord.recordingState == AudioRecord.RECORDSTATE_RECORDING) {
        val read = audioRecord.read(buffer, 0, buffer.size)
        if (read > 0) {
            val volume = buffer.maxOrNull()?.toFloat()?.div(32767f) ?: 0f  // Normalize volume (0 to 1)
            onVolumeMeasured(volume * 100)  // Scale up
        }
        delay(70)  // Sample volume every 70ms
    }

    audioRecord.stop()
    audioRecord.release()
}

@Composable
fun MouthCanvas(mouthHeight: Float) {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(top = 32.dp)
    ) {
        val centerX = size.width / 2
        val centerY = size.height / 2

        // Face Circle
        drawCircle(
            color = Color.Yellow,
            center = Offset(centerX, centerY - 50),
            radius = 100f
        )

        // Eyes
        drawCircle(color = Color.Black, center = Offset(centerX - 40, centerY - 80), radius = 10f)
        drawCircle(color = Color.Black, center = Offset(centerX + 40, centerY - 80), radius = 10f)

        // Mouth (Simulated movement)
        drawRoundRect(
            color = Color.Red,
            topLeft = Offset(centerX - 50, centerY - 30),
            size = androidx.compose.ui.geometry.Size(100f, mouthHeight),
            cornerRadius = CornerRadius(30f, 30f)
        )
    }
}
