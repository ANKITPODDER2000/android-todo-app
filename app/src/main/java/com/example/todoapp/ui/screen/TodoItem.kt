package com.example.todoapp.ui.screen

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.module.Todo
import com.example.todoapp.ui.theme.todoContentColor
import com.example.todoapp.ui.theme.todoItemContainerColor
import com.example.todoapp.utility.getTodo

@Composable
fun TodoItem(todo: Todo, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxWidth(1f),
        shadowElevation = 4.dp,
        color = MaterialTheme.colorScheme.todoItemContainerColor,
        contentColor = MaterialTheme.colorScheme.todoContentColor,
        tonalElevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = todo.title,
                    color = MaterialTheme.colorScheme.todoContentColor,
                    modifier = Modifier.weight(1f),
                    fontSize = 20.sp
                )
                Canvas(
                    modifier = Modifier
                        .width(16.dp)
                        .height(16.dp)
                ) {
                    drawCircle(color = todo.priority.color)
                }
            }
            Text(
                text = todo.description,
                color = MaterialTheme.colorScheme.todoContentColor,
                modifier = Modifier.padding(top = 8.dp),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}


@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES, name = "night_mode")
@Composable
fun PreviewTodoItem() {
    TodoItem(
        todo = getTodo
    )
}