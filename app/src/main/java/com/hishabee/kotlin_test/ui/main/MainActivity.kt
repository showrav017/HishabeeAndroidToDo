package com.hishabee.kotlin_test.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.toArgb
import androidx.core.view.WindowInsetsControllerCompat
import com.hishabee.kotlin_test.ui.base.BaseActivity
import com.hishabee.kotlin_test.ui.screens.todo_list.NavGraphs
import com.ramcosta.composedestinations.DestinationsNavHost
import com.hishabee.kotlin_test.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                window?.statusBarColor = MaterialTheme.colorScheme.background.toArgb()
                WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = !isSystemInDarkTheme()
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }

    override fun viewRelatedTask() {}
}