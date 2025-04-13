package com.example.qt.ui.components

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.qt.R
import com.example.qt.models.Story

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Menu(
    stories: MutableState<MutableList<Story>>,
    isStoryWork: MutableState<Boolean>,
    onStop: () -> Unit,
    onClick: (List<Pair<String, String>>) -> Unit
) {
    LazyColumn(
        modifier = Modifier.padding(vertical = (3.5).dp, horizontal = 5.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(stories.value){ story ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(2.dp)
                    .paint(painter = painterResource(id = R.drawable.menu_btn))
                    .combinedClickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = {
                        if (isStoryWork.value) {
                            onStop()
                        }
                        isStoryWork.value = true
                        onClick(story.content)
                    }
                )
            ) {
                Text(
                    text = story.title,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.white)
                )
            }
        }
    }
}