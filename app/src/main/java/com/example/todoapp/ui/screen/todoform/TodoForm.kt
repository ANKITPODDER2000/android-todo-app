package com.example.todoapp.ui.screen.todoform

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todoapp.ui.theme.todoContainerColor

@Composable
fun TodoForm(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.todoContainerColor)
            .padding(16.dp)
    ) {
        InputTextField( "Todo Title", Modifier.fillMaxWidth(1f) )
        InputTextField( "Todo Description", Modifier.fillMaxSize().padding(top = 8.dp) )
    }
}

@Preview(showSystemUi = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, showSystemUi = true)
@Composable
fun PreviewTodoForm() {
    TodoForm()
}