package com.example.todoapp.ui.screen.tododetails

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TodoDetailsScreen(todoId: String?, dismissHandler: () -> Unit) {
    if (todoId == null) {
        ShowErrorDialog(dismissHandler)
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

@Preview
@Composable
fun PreviewTodoDetailsScreen() {
    TodoDetailsScreen(null) { }
}