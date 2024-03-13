package com.michael.noteapp.feature_note.presentation.components

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun ComposeIconButton(
    modifier: Modifier,
    imageVector: ImageVector,
    contentDescription: String,
    tint: Color,
    onClick: () -> Unit,
) {
    IconButton(
        modifier = modifier,
        onClick = onClick,
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = contentDescription,
            tint = tint
        )
    }
}

@Composable
fun ComposeFAB(
    onClick: () -> Unit,
    backGroundColor: Color,
    imageVector: ImageVector,
    contentDescription: String
){
    FloatingActionButton(
        onClick = { onClick() },
        backgroundColor = backGroundColor
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = contentDescription
        )
    }
}