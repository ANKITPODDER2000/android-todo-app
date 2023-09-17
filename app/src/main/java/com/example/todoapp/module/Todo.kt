package com.example.todoapp.module

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.todoapp.utility.DataBaseConst.TODO_TABLE_NAME
import com.example.todoapp.utility.TaskPriority

@Entity(tableName = TODO_TABLE_NAME)
data class Todo(
    var title: String,
    var description: String,
    var priority: TaskPriority,
    var startDate: String = "17/09/2023",
    var targetedEndDate: String = "17/09/2023",
    var endDate: String = "17/09/2023",
    var isCompleted: Boolean = false,
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
)
