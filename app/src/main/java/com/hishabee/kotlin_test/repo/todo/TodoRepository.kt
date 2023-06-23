package com.hishabee.kotlin_test.repo.todo

import com.hishabee.kotlin_test.db.RoomHelper
import com.hishabee.kotlin_test.network.AppNetworkState
import com.hishabee.kotlin_test.network.IApiService
import com.hishabee.kotlin_test.preference.PreferencesHelper
import com.hishabee.kotlin_test.repo.BaseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TodoRepository @Inject constructor(
    override var apiService: IApiService,
    override var preferencesHelper: PreferencesHelper,
    override var roomHelper: RoomHelper
) : ITodoRepository, BaseRepository() {
    override suspend fun getAllTodoList(): Flow<AppNetworkState<Any>> {
        TODO("Not yet implemented")
    }
}