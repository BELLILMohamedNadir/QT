package com.example.qt.utils

import androidx.compose.runtime.MutableState
import com.example.qt.R
import com.example.qt.models.StoryRepository

class EmotionEffect{
    companion object{
        fun changeEmotionEffect(emotions: MutableState<Int>,emotion:String){
            when (emotion) {
                StoryRepository.JOIE -> emotions.value = R.raw.qt_happy
                StoryRepository.PEUR -> emotions.value = R.raw.qt_afraid
                StoryRepository.COLERE -> emotions.value = R.raw.qt_angry
                StoryRepository.FIERTE -> emotions.value = R.raw.qt_proud
                StoryRepository.ECLATE_RIRE -> emotions.value = R.raw.qt_happy
                StoryRepository.EXCITATION -> emotions.value = R.raw.qt_happy_blinking
                StoryRepository.HONTEUX -> emotions.value = R.raw.qt_shy
                StoryRepository.INQUIETUDE -> emotions.value = R.raw.qt_afraid
                StoryRepository.JALOUSIE -> emotions.value = R.raw.qt_disgusted
                StoryRepository.LÉGER -> emotions.value = R.raw.qt_calming_down
                StoryRepository.TRISTESSE -> emotions.value = R.raw.qt_sad
                StoryRepository.TALKING -> emotions.value = R.raw.qt_talking

                else -> emotions.value = R.raw.qt_talking
            }
        }
    }
}