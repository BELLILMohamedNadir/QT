package com.example.qt


import android.os.Build
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import com.example.qt.models.StoryRepository
import com.example.qt.ui.components.QT
import com.example.qt.ui.theme.QTTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private lateinit var textToSpeech: TextToSpeech
    private val emotion : MutableState<Int> =  mutableIntStateOf(R.raw.qt_neutral)
    private val isStoryWork : MutableState<Boolean> =  mutableStateOf(false)
    private var remainingSentences = 0
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()

        textToSpeech = TextToSpeech(this) { status ->
            if (status == TextToSpeech.SUCCESS) {
                textToSpeech.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
                    override fun onStart(utteranceId: String?) {
                        val emotion = utteranceId
                        emotion?.let {
                            Log.d("Emotion", "Émotion détectée : $it")
                            changeEmotionEffect(it)
                        }
                    }

                    override fun onDone(utteranceId: String?) {
                        remainingSentences--
                        if (remainingSentences == 0){
                            runOnUiThread {
                                isStoryWork.value = false
                            }
                        }
                    }
                    override fun onError(utteranceId: String?) {}
                })
            }
        }


        val stories = StoryRepository.stories
        val backgrounds = StoryRepository.backgrounds

        setContent {
            QTTheme {
                QT(
                    stories = stories,
                    emotion = emotion,
                    backgrounds = backgrounds,
                    onStop = {
                        textToSpeech.stop()
                    },
                    isStoryWork = isStoryWork,
                ){story ->
                    remainingSentences = story.size
                    for ((sentence, emotion) in story) {
                        textToSpeech.speak(sentence, TextToSpeech.QUEUE_ADD, null, emotion)
                    }
                }
            }
        }
    }

    fun changeEmotionEffect(emotion:String){
        when (emotion) {
            StoryRepository.JOIE -> this.emotion.value = R.raw.qt_happy
            StoryRepository.PEUR -> this.emotion.value = R.raw.qt_afraid
            StoryRepository.COLERE -> this.emotion.value = R.raw.qt_angry
            StoryRepository.FIERTE -> this.emotion.value = R.raw.qt_proud
            StoryRepository.ECLATE_RIRE -> this.emotion.value = R.raw.qt_happy
            StoryRepository.EXCITATION -> this.emotion.value = R.raw.qt_happy_blinking
            StoryRepository.HONTEUX -> this.emotion.value = R.raw.qt_shy
            StoryRepository.INQUIETUDE -> this.emotion.value = R.raw.qt_afraid
            StoryRepository.JALOUSIE -> this.emotion.value = R.raw.qt_disgusted
            StoryRepository.LÉGER -> this.emotion.value = R.raw.qt_calming_down
            StoryRepository.TRISTESSE -> this.emotion.value = R.raw.qt_sad
            StoryRepository.TALKING -> this.emotion.value = R.raw.qt_talking

            else -> this.emotion.value = R.raw.qt_talking
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        textToSpeech.stop()
        textToSpeech.shutdown()
    }
}

