package com.hishabee.kotlin_test.ui.screens.splash

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.hishabee.kotlin_test.R
import com.hishabee.kotlin_test.network.data.contents.ContentResponse
import com.hishabee.kotlin_test.ui.base.BaseComponent
import com.hishabee.kotlin_test.ui.base.UIState
import com.hishabee.kotlin_test.ui.util.showToast
import kotlinx.coroutines.delay

@RootNavGraph(start = true)
@Destination
@Composable
fun AnimatedSplashScreen(navigator: DestinationsNavigator) {
    val splashViewModel: SplashViewModel = hiltViewModel()
    var startAnimation by remember { mutableStateOf(false) }
    val animationTimeout = 3000
    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(animationTimeout.toLong())

        splashViewModel.uiState.collect {
            when (it) {
                is UIState.Loading -> {}
                is UIState.DataLoaded -> {

                }

                is UIState.Error -> {
                    context.showToast(it.message)
                }

                else -> {

                }
            }
        }
    }

    BaseComponent(
        progressBarState = splashViewModel.showProgressBar.collectAsState(),
        unauthorizedState = splashViewModel.unauthorized.collectAsState(),
        progressBarContent = {},
        unAuthorizedContent = {

        }
    ) {
    }
}