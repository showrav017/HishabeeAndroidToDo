package com.hishabee.kotlin_test.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hishabee.kotlin_test.db.dao.TodoDao
import com.hishabee.kotlin_test.db.entity.Todo


@Database(entities = [Todo::class], version = 1, exportSchema = false)
abstract class RoomDB : RoomDatabase() {

    abstract fun todoDao(): TodoDao
}