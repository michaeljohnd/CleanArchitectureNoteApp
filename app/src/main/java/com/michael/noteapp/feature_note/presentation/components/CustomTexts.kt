package com.michael.noteapp.feature_note.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun ComposeNoteText(
    text: String,
    style: TextStyle,
    color: Color,
    maxLines: Int,
    overFlow: TextOverflow,
    fontWeight: FontWeight?,
    modifier: Modifier
) {
    Text(
        modifier = modifier
            .fillMaxWidth(),
        text = text,
        style = style,
        color = color,
        maxLines = maxLines,
        overflow = overFlow,
        fontWeight = fontWeight
    )
}

@Composable
fun ComposeText(
    text: String,
    style: TextStyle,
) {
    Text(
        text = text,
        style = style
    )
}