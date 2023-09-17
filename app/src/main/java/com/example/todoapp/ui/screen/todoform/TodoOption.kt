package com.example.todoapp.ui.screen.todoform

import android.content.res.Configuration
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import com.example.todoapp.R
import com.example.todoapp.ui.screen.topappbar.TodoDropDownMenuItem
import com.example.todoapp.ui.theme.todoContentColor
import com.example.todoapp.ui.theme.todoItemContainerColor
import com.example.todoapp.utility.TaskPriority

@Composable
fun TodoOption(
    selectedTaskPriority: TaskPriority,
    handleTaskPriorityChangeListener: (TaskPriority) -> Unit,
    modifier: Modifier = Modifier,
) {
    var isExpanded by rememberSaveable {
        mutableStateOf(false)
    }
    val dropDownOptionHandler: (TaskPriority?) -> Unit = { priority: TaskPriority? ->
        priority?.let {
            isExpanded = false
            handleTaskPriorityChangeListener(it)
        }
    }
    var rowSize by remember { mutableStateOf(Size(1f, 1f)) }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            modifier = modifier
                .fillMaxWidth(1f)
                .height(64.dp)
                .clickable {
                    isExpanded = !isExpanded
                }
                .clip(MaterialTheme.shapes.small)
                .background(MaterialTheme.colorScheme.todoItemContainerColor)
                .onGloballyPositioned { layoutCoordinates ->
                    rowSize = layoutCoordinates.size.toSize()
                }
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = DefaultAlpha),
                    shape = MaterialTheme.shapes.small
                )
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Canvas(modifier = Modifier.size(16.dp)) {
                drawCircle(color = selectedTaskPriority.color)
            }
            Text(
                text = selectedTaskPriority.name,
                color = MaterialTheme.colorScheme.todoContentColor,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(1f)
            )
            IconButton(onClick = { isExpanded = !isExpanded }) {
                Icon(
                    imageVector = if (isExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = stringResource(R.string.drop_down_arrow),
                    tint = MaterialTheme.colorScheme.todoContentColor
                )
            }
        }
        DropdownMenu(
            expanded = (isExpanded),
            onDismissRequest = { isExpanded = false },
            modifier = Modifier.width(with(LocalDensity.current) { rowSize.width.toDp() })
        ) {
            TodoDropDownMenuItem(
                taskPriority = TaskPriority.LOW,
                dropDownOptionHandler
            )
            TodoDropDownMenuItem(
                taskPriority = TaskPriority.MEDIUM,
                dropDownOptionHandler,
                modifier = Modifier.fillMaxWidth(1f)
            )
            TodoDropDownMenuItem(
                taskPriority = TaskPriority.HIGH,
                dropDownOptionHandler,
                modifier = Modifier.fillMaxWidth(1f)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, name = "night_mode")
@Composable
fun PreviewTodoItem() {
    TodoOption(TaskPriority.HIGH, { })
}