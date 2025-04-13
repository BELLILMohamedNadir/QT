package com.example.qt


import android.os.Build
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import com.example.qt.models.Story
import com.example.qt.models.StoryRepository
import com.example.qt.ui.components.QT
import com.example.qt.ui.theme.QTTheme
import com.example.qt.utils.EmotionEffect
import java.util.Locale

class MainActivity : ComponentActivity() {
    private lateinit var textToSpeech: TextToSpeech
    private val emotions : MutableState<Int> =  mutableIntStateOf(R.raw.qt_neutral)
    private val isStoryWork : MutableState<Boolean> =  mutableStateOf(false)
    private var stories :  MutableState<MutableList<Story>> = mutableStateOf(mutableStateListOf())
    private val selectedLanguage : MutableState<String> =  mutableStateOf("FR")
    private var remainingSentences = 0

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        textToSpeechInitializer();

        stories.value = StoryRepository.storiesFR
        val backgrounds = StoryRepository.backgrounds

        setContent {
            QTTheme {
                QT(
                    stories = stories,
                    emotion = emotions,
                    backgrounds = backgrounds,
                    onStop = {
                        textToSpeech.stop()
                        isStoryWork.value = false
                        if (selectedLanguage.value == "FR"){
                            textToSpeech.setLanguage(Locale.FRENCH)
                            stories.value = StoryRepository.storiesFR
                            textToSpeech.setPitch(1.5f)
                            textToSpeech.setSpeechRate(1.2f)
                        }else{
                            textToSpeech.setLanguage(Locale.ENGLISH)
                            stories.value = StoryRepository.storiesEN
                            textToSpeech.setPitch(1.2f)
                            textToSpeech.setSpeechRate(1.4f)
                        }
                    },
                    isStoryWork = isStoryWork,
                    selectedLanguage = selectedLanguage
                ){story ->
                    remainingSentences = story.size
                    for ((sentence, emotion) in story) {
                        textToSpeech.speak(sentence, TextToSpeech.QUEUE_ADD, null, emotion)
                    }
                }
            }
        }
    }

    private fun textToSpeechInitializer() {
        textToSpeech = TextToSpeech(this) { status ->
            if (status == TextToSpeech.SUCCESS) {
                textToSpeech.setPitch(1.5f)
                textToSpeech.setSpeechRate(1.2f)
                textToSpeech.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
                    override fun onStart(utteranceId: String?) {
                        utteranceId?.let {
                            Log.d("Emotion", "Émotion détectée : $it")
                            EmotionEffect.changeEmotionEffect(emotions, it)
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
    }


    override fun onDestroy() {
        super.onDestroy()
        textToSpeech.stop()
        textToSpeech.shutdown()
    }
}

