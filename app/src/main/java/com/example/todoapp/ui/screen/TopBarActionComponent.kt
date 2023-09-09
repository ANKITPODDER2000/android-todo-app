package com.example.todoapp.ui.screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.todoapp.R
import com.example.todoapp.ui.theme.scaffoldContentColor
import com.example.todoapp.utility.TaskPriority


@Composable
fun DeleteButton() {
    IconButton(onClick = { /*TODO*/ }) {
        Icon(
            imageVector = Icons.Filled.Delete,
            contentDescription = stringResource(R.string.search_button)
        )
    }
}

@Composable
fun SortButton() {
    var isExpanded: Boolean by rememberSaveable {
        mutableStateOf(false)
    }
    IconButton(onClick = { isExpanded = !isExpanded }) {
        Icon(
            painter =
            if (isExpanded)
                painterResource(id = R.drawable.baseline_filter_list_off_24)
            else painterResource(
                id = R.drawable.baseline_filter_list_24
            ),
            contentDescription = stringResource(R.string.sort_the_todo_items),
            tint = MaterialTheme.colorScheme.scaffoldContentColor
        )
        TodoDropDown(isExpanded) {
            isExpanded = !isExpanded
        }
    }
}

@Composable
fun TodoDropDown(
    isExpanded: Boolean = false,
    handleTodoDropDownMenuItemClick: (TaskPriority?) -> Unit,
) {
    DropdownMenu(
        expanded = isExpanded,
        onDismissRequest = { handleTodoDropDownMenuItemClick(null) }
    ) {
        TodoDropDownMenuItem(TaskPriority.HIGH, handleTodoDropDownMenuItemClick)
        TodoDropDownMenuItem(TaskPriority.MEDIUM, handleTodoDropDownMenuItemClick)
        TodoDropDownMenuItem(TaskPriority.LOW, handleTodoDropDownMenuItemClick)
    }
}

@Composable
fun TodoDropDownMenuItem(
    taskPriority: TaskPriority,
    handleTodoDropDownMenuItemClick: (TaskPriority?) -> Unit,
) {
    DropdownMenuItem(
        text = { Text(text = taskPriority.name, modifier = Modifier.padding(end = 16.dp)) },
        onClick = { handleTodoDropDownMenuItemClick(taskPriority) },
        leadingIcon = {
            Canvas(modifier = Modifier.size(16.dp)) {
                drawCircle(taskPriority.color)
            }
        }
    )
}

@Composable
fun SearchButton(handleSearchButtonClicked: () -> Unit) {
    IconButton(onClick = { handleSearchButtonClicked() }) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = stringResource(R.string.search_button)
        )
    }
}
