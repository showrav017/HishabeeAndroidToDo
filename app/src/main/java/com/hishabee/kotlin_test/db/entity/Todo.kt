package com.hishabee.kotlin_test.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @ColumnInfo(name = "todo_title")
    var todo_title: String? = null,

    @ColumnInfo(name = "created_at")
    var created_at: String? = null,

    @ColumnInfo(name = "status")
    var status: String? = null,
)
