package com.example.todoapp.ui.screen.tododetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoapp.module.Todo
import com.example.todoapp.utility.DBState
import com.example.todoapp.utility.getTodo
import com.example.todoapp.viewmodel.TodoAppDetailViewModel

@Composable
fun TodoDetailsScreen(
    todoAppDetailViewModel: TodoAppDetailViewModel,
    todoId: String?,
    dismissHandler: () -> Unit,
) {
    val id = try {
        todoId?.toInt() ?: -1
    } catch (e: Exception) {
        -1
    }
    if (id == -1) {
        ShowErrorDialog(dismissHandler)
    } else {
        val todoDBState by todoAppDetailViewModel.getSelectedTodo(id).collectAsState()
        TodoDetails(dbState = todoDBState)
    }
}

@Composable
fun TodoDetails(dbState: DBState) {
    when (dbState) {
        is DBState.NotStarted -> TodoDetailEmptyScreen()
        is DBState.FetchTodoSuccessfully -> TodoInformationScreen(dbState.todo)
        else -> TodoDetailEmptyScreen()
    }
}

@Composable
fun TodoInformationScreen(todo: Todo) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = todo.title,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 32.dp)
        )
        Text(
            text = todo.description,
            fontSize = 18.sp,
            fontWeight = FontWeight.Light,
            lineHeight = 26.sp
        )
    }
}

@Composable
fun TodoDetailEmptyScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Fetching info...", fontSize = 24.sp)
    }
}

@Composable
fun ShowErrorDialog(dismissHandler: () -> Unit) {
    AlertDialog(
        onDismissRequest = { dismissHandler() },
        confirmButton = {
            TextButton(onClick = { dismissHandler() }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Ok", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
            }
        },
        title = {
            Text(
                text = "Todo App",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        },
        text = { Text(text = "Oops sorry something went wrong, please try again letter") },
    )

}

@Preview(showSystemUi = true)
@Composable
fun PreviewTodoDetailsScreen() {
    TodoDetails(DBState.FetchTodoSuccessfully(getTodo))
}