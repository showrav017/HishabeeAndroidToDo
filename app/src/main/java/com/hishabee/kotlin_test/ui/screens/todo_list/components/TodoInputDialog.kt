package com.hishabee.kotlin_test.ui.screens.todo_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.hishabee.kotlin_test.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoInputDialog(cancleTapped: () -> Unit, yesTapped: (todoInfo:String) -> Unit) {
    var isDialogOpen by remember { mutableStateOf(true) }
    var userInput by remember { mutableStateOf(TextFieldValue("")) }

    if (isDialogOpen) {
        // Create a dialog with a title and a body.
        Dialog(
            onDismissRequest = { isDialogOpen = false },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            )
        ) {
            Box(modifier = Modifier
                .background(colorResource(id = R.color.white), shape = RoundedCornerShape(10.dp))){
                Column(
                    modifier = Modifier
                        .padding(0.dp)
                        .padding(20.dp)
                ) {
                    Text(
                        stringResource(id = R.string.new_todo),
                        style = MaterialTheme.typography.titleLarge
                            .copy(
                                color = MaterialTheme.colorScheme.primary
                            )
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    TextField(
                        value = userInput,
                        maxLines = 1,
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Done,
                        ),
                        onValueChange = {
                            userInput = it
                        }
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(), horizontalArrangement = Arrangement.End)
                    {
                        Text(
                            text = stringResource(id = R.string.cancel),
                            style = MaterialTheme.typography.titleSmall
                                .copy(
                                    color = MaterialTheme.colorScheme.primary
                                ),
                            modifier = Modifier
                                .clickable {
                                    isDialogOpen = false
                                    cancleTapped()
                                }
                        )
                        Spacer(modifier = Modifier.width(20.dp))
                        Text(
                            text = stringResource(id = R.string.save),
                            style = MaterialTheme.typography.titleSmall
                                .copy(
                                    color = MaterialTheme.colorScheme.primary
                                ),
                            modifier = Modifier
                                .clickable {
                                    isDialogOpen = false
                                    yesTapped(userInput.text)
                                }
                        )
                    }
                }
            }
        }
    }
}

