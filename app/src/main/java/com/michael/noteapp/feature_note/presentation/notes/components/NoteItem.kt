package com.michael.noteapp.feature_note.presentation.notes.components

import android.annotation.SuppressLint
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.michael.noteapp.feature_note.domain.model.Note
import com.michael.noteapp.feature_note.presentation.components.ComposeCanvas
import com.michael.noteapp.feature_note.presentation.components.ComposeNoteText
import com.michael.noteapp.feature_note.presentation.components.ComposeIconButton

@SuppressLint("UnusedTransitionTargetStateParameter")
@Composable
fun NoteItem(
    note: Note,
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 10.dp,
    cutCornerSize: Dp = 30.dp,
    onStarClick: () -> Unit,
    onDeleteClick: () -> Unit
) {
    Box(
        modifier = modifier
    ) {
        ComposeCanvas(modifier = Modifier.matchParentSize(), note, cornerRadius, cutCornerSize)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(end = 32.dp)
        ) {
            val checkedState = remember { mutableStateOf(false) }
            Row {
                IconToggleButton(
                    checked = checkedState.value,
                    onCheckedChange = {
                        checkedState.value = !checkedState.value
                    },
                    modifier = Modifier
                ) {
                    val transition = updateTransition(checkedState.value, label = "transition")
                    val tint by transition.animateColor(label = "iconColor") { isChecked ->
                        if (isChecked) Color.Yellow else Color.Black
                    }

                    val size by transition.animateDp(
                        transitionSpec = {
                            if (false isTransitioningTo true) {
                                keyframes {
                                    durationMillis = 250
                                    30.dp at 0 with LinearOutSlowInEasing
                                    35.dp at 15 with FastOutLinearInEasing
                                    40.dp at 75
                                    35.dp at 150
                                }
                            } else {
                                spring(stiffness = Spring.StiffnessVeryLow)
                            }
                        },
                        label = "Size"
                    ) { 30.dp }
                    Icon(
                        imageVector = if (checkedState.value) Icons.Filled.Star else Icons.Filled.StarBorder,
                        contentDescription = "Icon",
                        tint = tint,
                        modifier = Modifier.size(size)
                    )
                }
                ComposeNoteText(
                    text = note.title,
                    style = MaterialTheme.typography.h5,
                    color = MaterialTheme.colors.onSurface,
                    maxLines = 1,
                    overFlow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 5.dp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            ComposeNoteText(
                text = note.content,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface,
                maxLines = 10,
                overFlow = TextOverflow.Ellipsis,
                fontWeight = null,
                modifier = Modifier
            )
        }
        ComposeIconButton(
            modifier = Modifier.align(Alignment.BottomEnd),
            imageVector = Icons.Default.Delete,
            contentDescription = "Delete Note",
            tint = MaterialTheme.colors.onSurface,
            onDeleteClick
        )
    }
}