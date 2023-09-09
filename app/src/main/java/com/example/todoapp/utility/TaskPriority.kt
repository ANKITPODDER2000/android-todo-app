package com.example.todoapp.utility

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import com.example.todoapp.ui.theme.HighPriority
import com.example.todoapp.ui.theme.LowPriority
import com.example.todoapp.ui.theme.MediumPriority
import com.example.todoapp.ui.theme.NonePriority

enum class TaskPriority(val color: Color) {
    HIGH(HighPriority),
    MEDIUM(MediumPriority),
    LOW(LowPriority),
    NONE(NonePriority)
}