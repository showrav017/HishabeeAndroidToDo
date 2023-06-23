package com.hishabee.kotlin_test.ui.screens.todo_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.hishabee.kotlin_test.ui.base.BaseComponent
import com.hishabee.kotlin_test.ui.base.UIState
import com.hishabee.kotlin_test.ui.screens.todo_list.components.*
import com.hishabee.kotlin_test.ui.util.showToast
import kotlinx.coroutines.delay

@RootNavGraph(start = true)
@Destination
@Composable
fun ToDoScreen(navigator: DestinationsNavigator) {
    val viewModel: ToDoViewModel = hiltViewModel()
    val context = LocalContext.current
    var showDialog by remember { mutableStateOf<Boolean>(false) }

    LaunchedEffect(key1 = true) {
        viewModel.getList()
    }

    BaseComponent(
        progressBarState = viewModel.showProgressBar.collectAsState(),
        unauthorizedState = viewModel.unauthorized.collectAsState(),
        progressBarContent = {},
        showDialog = showDialog,
        unAuthorizedContent = {},
        dialogContent= {
            TodoInputDialog(cancleTapped = {showDialog = false}){
                showDialog = false
                viewModel.createNewToDo(it)
            }
        }
    ) {
        Column(Modifier.fillMaxWidth()) {
            TopBar()
            Box(Modifier.fillMaxHeight(1f)) {
                Body(viewModel){
                    showDialog = true
                }
            }
        }
    }
}