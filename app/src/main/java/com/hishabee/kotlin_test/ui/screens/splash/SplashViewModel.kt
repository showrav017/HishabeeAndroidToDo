package com.hishabee.kotlin_test.ui.screens.splash


import androidx.lifecycle.*
import com.google.gson.Gson
import com.hishabee.kotlin_test.R
import com.hishabee.kotlin_test.preference.PreferencesHelper
import com.hishabee.kotlin_test.repo.todo.ITodoRepository
import com.hishabee.kotlin_test.ui.base.BaseViewModel
import com.hishabee.kotlin_test.ui.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    var preferencesHelper: PreferencesHelper,
    var todoRepository: ITodoRepository
) : BaseViewModel() {

}


