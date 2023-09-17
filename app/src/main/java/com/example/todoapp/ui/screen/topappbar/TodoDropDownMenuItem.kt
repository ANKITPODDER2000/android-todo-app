package com.example.todoapp.ui.screen.topappbar

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.todoapp.utility.TaskPriority

@Composable
fun TodoDropDownMenuItem(
    taskPriority: TaskPriority,
    handleTodoDropDownMenuItemClick: (TaskPriority?) -> Unit,
    modifier: Modifier = Modifier
) {
    DropdownMenuItem(
        modifier = modifier,
        text = { Text(text = taskPriority.name, modifier = Modifier.padding(end = 16.dp)) },
        onClick = { handleTodoDropDownMenuItemClick(taskPriority) },
        leadingIcon = {
            Canvas(modifier = Modifier.size(16.dp)) {
                drawCircle(taskPriority.color)
            }
        }
    )
}