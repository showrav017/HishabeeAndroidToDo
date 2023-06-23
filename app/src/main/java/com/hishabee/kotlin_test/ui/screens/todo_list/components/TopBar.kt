package com.hishabee.kotlin_test.ui.screens.todo_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.ViewCozy
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hishabee.kotlin_test.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                stringResource(id = R.string.all_tasks),
                style = MaterialTheme.typography.titleLarge
                    .copy(
                        color = MaterialTheme.colorScheme.primary
                    )
            )
        },
        modifier = Modifier
            .fillMaxWidth().padding(horizontal = 15.dp),
        navigationIcon = {
            Icon(
                imageVector = Icons.Outlined.Menu,
                contentDescription = ""
            )
        },
    )
}