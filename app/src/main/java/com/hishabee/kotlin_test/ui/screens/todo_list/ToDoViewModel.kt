package com.hishabee.kotlin_test.ui.screens.todo_list


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.*
import com.google.gson.Gson
import com.hishabee.kotlin_test.R
import com.hishabee.kotlin_test.db.RoomHelper
import com.hishabee.kotlin_test.db.entity.Todo
import com.hishabee.kotlin_test.preference.PreferencesHelper
import com.hishabee.kotlin_test.repo.todo.ITodoRepository
import com.hishabee.kotlin_test.ui.base.BaseViewModel
import com.hishabee.kotlin_test.ui.util.Constants
import com.hishabee.kotlin_test.ui.util.Constants.Companion.TODO_PENDING_STATUS
import com.hishabee.kotlin_test.ui.util.DateTimeUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ToDoViewModel @Inject constructor(
    var preferencesHelper: PreferencesHelper,
    var todoRepository: ITodoRepository,
    var roomHelper: RoomHelper
) : BaseViewModel() {

    var todoList by mutableStateOf(emptyList<Todo>())

    fun getList() {
        viewModelScope.launch {
            roomHelper.getDatabase().todoDao().getList().collect {
                todoList = it
            }
        }
    }

    fun createNewToDo(todo_title: String) {
        viewModelScope.launch {
            roomHelper.getDatabase().todoDao().insert(
                Todo(
                    todo_title = todo_title,
                    created_at = DateTimeUtil.todayDateTimeForApi,
                    status = TODO_PENDING_STATUS
                )
            )
            getList()
        }
    }

    fun setItemDone(id:Int)
    {
        viewModelScope.launch {
            roomHelper.getDatabase().todoDao().updateStatus(id)
            getList()
        }
    }
}


