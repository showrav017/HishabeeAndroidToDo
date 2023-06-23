package com.hishabee.kotlin_test.repo.todo

import com.hishabee.kotlin_test.network.AppNetworkState
import com.hishabee.kotlin_test.repo.IBaseRepository
import kotlinx.coroutines.flow.Flow

interface ITodoRepository : IBaseRepository {
    suspend fun getAllTodoList(): Flow<AppNetworkState<Any>>
}