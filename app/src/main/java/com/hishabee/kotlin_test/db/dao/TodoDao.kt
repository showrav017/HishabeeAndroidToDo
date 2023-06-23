package com.hishabee.kotlin_test.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hishabee.kotlin_test.db.entity.Todo
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Query("SELECT * FROM Todo ORDER BY id DESC LIMIT 1")
    fun getLatestConfig(): Flow<Todo>

    @Query("SELECT CASE WHEN EXISTS(SELECT 1 FROM Todo) THEN 1 ELSE 0 END")
    fun isEmptyConfig(): Flow<Boolean>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(imagesConfig: Todo)
}