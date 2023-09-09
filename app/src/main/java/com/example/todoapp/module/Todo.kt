package com.example.todoapp.module

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.todoapp.utility.DataBaseConst.TODO_TABLE_NAME
import com.example.todoapp.utility.TaskPriority
import java.time.LocalDate

@Entity(tableName = TODO_TABLE_NAME)
data class Todo(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val startDate: String = LocalDate.parse("dd/mm/yyyy").toString(),
    val targetedEndDate: String,
    val endDate: String,
    val isCompleted: Boolean = false,
    val priority: TaskPriority
)
