package com.example.todoapp.ui.screen.todoform

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.todoapp.ui.theme.todoContainerColor
import com.example.todoapp.viewmodel.ViewModelProvider.todoFormViewModel

@Composable
fun TodoForm(modifier: Modifier = Modifier) {
    val formState by todoFormViewModel!!.formState.collectAsState()
    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.todoContainerColor)
            .padding(16.dp)
    ) {
        InputTextField(formState.title, { todoFormViewModel!!.updateTodoTitle(it) } ,"Todo Title", ImeAction.Next, Modifier.fillMaxWidth(1f) )
        TodoOption(formState.priority, { todoFormViewModel!!.updatePriority(it) } ,modifier = Modifier.padding(top = 16.dp))
        InputTextField(formState.description, { todoFormViewModel!!.updateTodoDescription(it) },"Todo Description", ImeAction.Done,
            Modifier
                .fillMaxSize()
                .padding(top = 8.dp) )
    }
}
