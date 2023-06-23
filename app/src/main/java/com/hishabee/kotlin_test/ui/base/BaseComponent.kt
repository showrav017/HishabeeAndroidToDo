package com.hishabee.kotlin_test.ui.base

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun BaseComponent(
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    progressBarState: State<Boolean>? = null,
    unauthorizedState: State<Boolean>? = null,
    showDialog: Boolean = false,
    dialogProperties: DialogProperties = DialogProperties(false, false),
    dialogContent: @Composable () -> Unit,
    progressBarContent: @Composable (Boolean) -> Unit,
    unAuthorizedContent: @Composable (Boolean) -> Unit,
    bodyContent: @Composable () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        bodyContent()

        progressBarContent(progressBarState?.value ?: false)

        unAuthorizedContent(unauthorizedState?.value ?: false)

        if(showDialog)
        {
            Dialog(
                onDismissRequest = {},
                properties = dialogProperties,
                content = {
                    dialogContent()
                }
            )
        }
    }
}