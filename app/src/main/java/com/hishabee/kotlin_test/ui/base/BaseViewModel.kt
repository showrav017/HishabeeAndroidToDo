package com.hishabee.kotlin_test.ui.base

import androidx.lifecycle.ViewModel
import com.hishabee.kotlin_test.network.AppNetworkState
import kotlinx.coroutines.flow.*

abstract class BaseViewModel : ViewModel() {
    private val _showProgressBar = MutableStateFlow(false)
    val showProgressBar = _showProgressBar.asStateFlow()

    private val _unauthorized = MutableStateFlow(false)
    val unauthorized = _unauthorized.asStateFlow()

    private val _uiState: MutableStateFlow<UIState<Any>?> = MutableStateFlow(null)
    val uiState: StateFlow<UIState<Any>?> = _uiState

    protected fun <T : Any> generateUiState(stateId: Int, state: AppNetworkState<T>) {
        when (state) {
            is AppNetworkState.Loading -> {
                _uiState.value = UIState.Loading(stateId = stateId)

                _showProgressBar.value = true

                _unauthorized.value = false
            }
            is AppNetworkState.Data -> {
                _uiState.value = UIState.DataLoaded(stateId = stateId, data = state.data)

                _showProgressBar.value = false

                _unauthorized.value = false
            }
            is AppNetworkState.Error -> {
                _uiState.value =
                    UIState.Error(
                        stateId = stateId,
                        message = state.exception.errorMessage ?: "",
                        unAuthorized = state.unauthorized
                    )

                _showProgressBar.value = false

                _unauthorized.value = state.unauthorized
            }
        }
    }

    protected fun <T : Any> generateUiState(stateId: Int, data: T) {
        _uiState.value = UIState.DataLoaded(stateId = stateId, data = data)
    }

    fun showProgressBar() {_showProgressBar.value = true}
    fun hideProgressBar() {_showProgressBar.value = false}
}

sealed class UIState<out T> {
    data class DataLoaded<out T>(val stateId: Int, val data: T) : UIState<T>()

    data class Loading(val stateId: Int) : UIState<Nothing>()

    data class Error(val stateId: Int, var message: String, var unAuthorized: Boolean = false) :
        UIState<Nothing>()

}