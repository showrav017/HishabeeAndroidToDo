package com.hishabee.kotlin_test.repo

import com.hishabee.kotlin_test.db.RoomHelper
import com.hishabee.kotlin_test.network.AppNetworkState
import com.hishabee.kotlin_test.network.IApiService
import com.hishabee.kotlin_test.network.NetworkErrorExceptions
import com.hishabee.kotlin_test.network.data.BaseResponse
import com.hishabee.kotlin_test.network.resolveError
import com.hishabee.kotlin_test.preference.PreferencesHelper
import com.hishabee.kotlin_test.util.makeJson
import com.hishabee.kotlin_test.util.makeObject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

abstract class BaseRepository : IBaseRepository {
    abstract var apiService: IApiService
    abstract var preferencesHelper: PreferencesHelper
    abstract var roomHelper: RoomHelper

    protected suspend fun <T : Any> handleNetworkCall(callback: suspend () -> T): Flow<AppNetworkState<T>> =
        flow {
            emit(AppNetworkState.Loading)

            try {
                val networkCall = AppNetworkState.Data(callback())
                val baseData = networkCall.data as BaseResponse
                baseData.details?.let { details ->
                    when (details.code) {
                        200, 201 -> {
                            emit(networkCall)
                        }
                        else -> {
                            if (!baseData.message.isNullOrEmpty()) {
                                throw NetworkErrorExceptions(
                                    errorCode = details.code ?: -1,
                                    errorBody = baseData,
                                    errorMessage = baseData.message,
                                    unauthorized = details.code == 401
                                )
                            }

                            throw NetworkErrorExceptions(
                                errorCode = details.code ?: -1,
                                errorBody = baseData,
                                unauthorized = details.code == 401
                            )
                        }
                    }
                }?:run {
                    when (baseData.code) {
                        200, 201 -> {
                            emit(networkCall)
                        }
                        else -> {
                            if (!baseData.message.isNullOrEmpty()) {
                                throw NetworkErrorExceptions(
                                    errorCode = baseData.code ?: -1,
                                    errorBody = baseData,
                                    errorMessage = baseData.message,
                                    unauthorized = baseData.code == 401
                                )
                            }

                            throw NetworkErrorExceptions(
                                errorCode = baseData.code ?: -1,
                                errorBody = baseData,
                                unauthorized = baseData.code == 401
                            )
                        }
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()

                emit(e.resolveError())
            }
        }
}