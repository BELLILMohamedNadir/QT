package com.example.qt.ui.components

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.qt.R
import com.example.qt.models.Story


@OptIn(ExperimentalFoundationApi::class)
@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun QT(modifier: Modifier = Modifier,
       stories : MutableState<MutableList<Story>>,
       emotion: MutableState<Int>,
       backgrounds: List<Int>,
       onStop: () -> Unit,
       isStoryWork: MutableState<Boolean>,
       selectedLanguage: MutableState<String>,
       onClick : (List<Pair<String, String>>) -> Unit) {

    var isListBackgroundShown by remember {
        mutableStateOf(false)
    }
    var backgroundImage by remember {
        mutableIntStateOf(backgrounds[0])
    }

    var selectedLanguageBackground by remember {
        mutableIntStateOf(R.drawable.ic_fr)
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = backgroundImage),
                contentScale = ContentScale.Crop
            ).combinedClickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = {
                    isListBackgroundShown = false
                }
            ),
    ) {
        //Body
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 40.dp, bottom = 10.dp)
                .padding(start = 10.dp, end = 30.dp, bottom = 20.dp, top = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.height(280.dp).width(330.dp).padding(start = 100.dp, bottom = 5.dp, top = 7.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(painter = painterResource(id = R.drawable.qt), contentDescription = "qt",
                    modifier = Modifier)
                RobotEmotion(isStoryWork, emotion)
            }

            //Menu
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .paint(painter = painterResource(id = R.drawable.menu))
                    .align(Alignment.CenterVertically)
                    .padding(10.dp)
            ){
                Menu(stories, isStoryWork, onStop){story ->
                    onClick(story)
                }
            }


        }

        // A list to change backgrounds
        Row(modifier = Modifier.padding(top = 10.dp)){
            Column {
                IconButton(
                    onClick = { isListBackgroundShown = !isListBackgroundShown },
                    modifier = Modifier) {
                    Icon(painter = painterResource(id = R.drawable.ic_settings),
                        contentDescription = "choices",
                        tint = Color.Unspecified)
                }
                Spacer(modifier = Modifier.height(5.dp))
                IconButton(
                    onClick = {
                        if (selectedLanguage.value.equals("FR")){
                            selectedLanguage.value = "EN"
                            selectedLanguageBackground = R.drawable.ic_en
                        }else{
                            selectedLanguage.value = "FR"
                            selectedLanguageBackground = R.drawable.ic_fr
                        }
                        onStop()
                              },
                    modifier = Modifier) {
                    Icon(painter = painterResource(id = selectedLanguageBackground),
                        contentDescription = "choices",
                        tint = Color.Unspecified)
                }
            }
            if (isStoryWork.value){
                IconButton(
                    onClick = {
                        isStoryWork.value = false;
                        onStop() },
                    modifier = Modifier) {
                    Icon(painter = painterResource(id = R.drawable.ic_quit),
                        contentDescription = "choices",
                        tint = Color.Unspecified)
                }
            }

            if (isListBackgroundShown) {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 5.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    items(backgrounds) { background ->
                        BackgroundCard(background) {
                            backgroundImage = background
                        }
                    }
                }
            }

        }

    }
}



