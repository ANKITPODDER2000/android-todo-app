package com.example.todoapp.ui.screen

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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.R
import com.example.todoapp.module.Todo
import com.example.todoapp.ui.theme.todoContainerColor
import com.example.todoapp.ui.theme.todoContentColor
import com.example.todoapp.utility.DBState
import com.example.todoapp.viewmodel.TodoAppViewModel

@Composable
fun TodoListScreen(todoAppViewModel: TodoAppViewModel,todoClickListener: (Int) -> Unit) {
    // todoAppViewModel.getAllTodo()
    val dbState by todoAppViewModel.dbState.collectAsState()
    if (dbState is DBState.FetchAllTodosSuccessfully) {
        val todos = (dbState as DBState.FetchAllTodosSuccessfully).todos
        if (todos.isEmpty()) TodoListEmptyScreen(stringResource(R.string.oooopss_please_add_your_first_todo))
        else TodoListItemScreens(todos = todos, todoClickListener = todoClickListener)
    } else if (dbState is DBState.Error) {
        TodoListEmptyScreen(text = (dbState as DBState.Error).error.message ?: "Error while fetching data")
    } else {
        TodoListEmptyScreen(text = stringResource(R.string.loading))
    }
}

@Composable
fun TodoListItemScreens(todos: List<Todo>, todoClickListener: (Int) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.todoContainerColor)
            .padding(16.dp)
    ) {
        items(todos) {
            TodoItem(todo = it, todoClickListener, modifier = Modifier.padding(top = 16.dp))
        }
    }
}

@Composable
fun TodoListEmptyScreen(text: String) {
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
            text = text,
            modifier = Modifier.padding(top = 8.dp),
            color = MaterialTheme.colorScheme.todoContentColor,
            fontSize = 20.sp
        )
    }
}

/*
@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun PreviewTodoListScreen() {
    TodoListScreen() { }
}

*/
