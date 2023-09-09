package com.example.todoapp.ui.screen

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.module.Todo
import com.example.todoapp.ui.theme.todoContainerColor
import com.example.todoapp.ui.theme.todoContentColor
import com.example.todoapp.utility.getTodoItems

@Composable
fun TodoListScreen(todos: List<Todo>) {
    if (todos.isEmpty()) {
        TodoListEmptyScreen()
    } else {
        TodoListItemScreens(todos)
    }
}

@Composable
fun TodoListItemScreens(todos: List<Todo>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.todoContainerColor)
            .padding(16.dp)
    ) {
        items(todos) {
            TodoItem(todo = it, modifier = Modifier.padding(top = 16.dp))
        }
    }
}

@Composable
fun TodoListEmptyScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.todoContainerColor),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "Welcome Image",
            tint = MaterialTheme.colorScheme.todoContentColor,
            modifier = Modifier
                .size(180.dp)
                .alpha(0.5f),
        )
        Text(
            text = "Oooopss, please add your first todo!",
            modifier = Modifier.padding(top = 8.dp),
            color = MaterialTheme.colorScheme.todoContentColor,
            fontSize = 20.sp
        )
    }
}

@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun PreviewTodoListScreen() {
    TodoListScreen(getTodoItems)
}

