package com.michael.noteapp.feature_note.presentation.notes.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.michael.noteapp.feature_note.domain.model.Note
import com.michael.noteapp.feature_note.presentation.components.ComposeCanvas
import com.michael.noteapp.feature_note.presentation.components.ComposeNoteText
import com.michael.noteapp.feature_note.presentation.components.ComposeIconButton

@Composable
fun NoteItem(
    note: Note,
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 10.dp,
    cutCornerSize: Dp = 30.dp,
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

            ComposeNoteText(
                text = note.title,
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.onSurface,
                maxLines = 1,
                overFlow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )

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

