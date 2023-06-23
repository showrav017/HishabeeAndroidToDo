package com.hishabee.kotlin_test.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hishabee.kotlin_test.db.entity.Todo
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Query("SELECT * FROM Todo ORDER BY status DESC, created_at DESC")
    fun getList(): Flow<List<Todo>>

    @Query("UPDATE Todo SET status = '0' WHERE id = :id")
    fun updateStatus(
        id: Int
    )

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(todoInfo: Todo)
}