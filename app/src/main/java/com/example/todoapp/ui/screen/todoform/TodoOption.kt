package com.example.todoapp.ui.screen.todoform

import android.content.res.Configuration
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todoapp.R
import com.example.todoapp.ui.theme.todoContentColor
import com.example.todoapp.ui.theme.todoItemContainerColor
import com.example.todoapp.utility.TaskPriority

@Composable
fun TodoOption(taskPriority: TaskPriority, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth(1f)
            .background(MaterialTheme.colorScheme.todoItemContainerColor)
            .height(64.dp)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = DefaultAlpha),
                shape = MaterialTheme.shapes.small
            )
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Canvas(modifier = Modifier.size(16.dp)) {
            drawCircle(color = taskPriority.color)
        }
        Text(
            text = taskPriority.name,
            color = MaterialTheme.colorScheme.todoContentColor,
            modifier = Modifier.padding(start = 16.dp)
        )
        Spacer(modifier = modifier.weight(1f))
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Filled.ArrowDropDown,
                contentDescription = stringResource(R.string.drop_down_arrow),
                tint = MaterialTheme.colorScheme.todoContentColor,
                modifier = modifier.rotate(0f)
            )
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, name = "night_mode")
@Composable
fun PreviewTodoItem() {
    TodoOption(TaskPriority.HIGH)
}