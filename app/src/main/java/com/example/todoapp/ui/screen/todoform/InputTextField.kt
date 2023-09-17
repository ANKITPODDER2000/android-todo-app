package com.example.todoapp.ui.screen.todoform

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import com.example.todoapp.ui.theme.todoContentColor
import com.example.todoapp.ui.theme.todoItemContainerColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputTextField(
    content: String,
    handleContentChangeHandler: (String) -> Unit,
    label: String,
    imeAction: ImeAction,
    modifier: Modifier = Modifier,
) {
    OutlinedTextField(
        value = content,
        onValueChange = { handleContentChangeHandler(it) },
        label = {
            Text(
                text = label,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.todoContentColor
            )
        },
        modifier = modifier,
        textStyle = MaterialTheme.typography.bodyLarge,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = MaterialTheme.colorScheme.todoItemContainerColor,
            textColor = MaterialTheme.colorScheme.todoContentColor
        ),
        keyboardOptions = KeyboardOptions(imeAction = imeAction)
    )
}