package com.example.todoapp.ui.screen

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoForm() {
    Column(
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(horizontal = 24.dp, vertical = 16.dp)
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = "",
            maxLines = 1,
            singleLine = true,
            onValueChange = {},
            label = { Text(text = "Todo title") },
            placeholder = {
                Text(
                    text = "Todo Title"
                )
            }
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp).requiredHeight(400.dp),
            value = "",
            maxLines = 1,
            singleLine = true,
            onValueChange = {},
            label = { Text(text = "Todo title") },
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.End)
        )
    }
}

@Preview(showSystemUi = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, showSystemUi = true)
@Composable
fun PreviewTodoForm() {
    TodoForm()
}