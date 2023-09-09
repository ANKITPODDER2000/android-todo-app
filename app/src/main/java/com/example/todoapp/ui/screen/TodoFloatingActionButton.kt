package com.example.todoapp.ui.screen

import android.content.res.Configuration
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.todoapp.R
import com.example.todoapp.ui.theme.scaffoldContainerColor
import com.example.todoapp.ui.theme.scaffoldContentColor

@Composable
fun TodoFloatingActionButton() {
    FloatingActionButton(
        onClick = { /*TODO*/ },
        contentColor = MaterialTheme.colorScheme.scaffoldContentColor,
        containerColor = MaterialTheme.colorScheme.scaffoldContainerColor
    ) {
        Icon(
            imageVector = Icons.Rounded.Add,
            contentDescription = stringResource(R.string.add_new_todo_item),
        )
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewTodoFloatingActionButton() {
    TodoFloatingActionButton()
}