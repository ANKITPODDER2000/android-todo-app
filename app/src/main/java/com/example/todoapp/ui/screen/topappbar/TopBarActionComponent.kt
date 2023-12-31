package com.example.todoapp.ui.screen.topappbar

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.todoapp.R
import com.example.todoapp.ui.theme.scaffoldContentColor
import com.example.todoapp.utility.TaskPriority

@Composable
fun HomeActionButtons(handleSearchButtonClicked: () -> Unit) {
    Row {
        SearchButton(handleSearchButtonClicked)
        SortButton()
        DeleteButton()
    }
}

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
    }
    TodoDropDown(isExpanded) {
        isExpanded = !isExpanded
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
fun SearchButton(handleSearchButtonClicked: () -> Unit) {
    IconButton(onClick = { handleSearchButtonClicked() }) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = stringResource(R.string.search_button)
        )
    }
}

@Composable
fun DoneButton(formSubmitListener: () -> Unit) {
    IconButton(onClick = { formSubmitListener() }) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = stringResource(R.string.done_button)
        )
    }
}

@Composable
fun EditButton() {
    IconButton(onClick = { /* Todo */ }) {
        Icon(
            imageVector = Icons.Filled.Edit,
            contentDescription = stringResource(R.string.done_button)
        )
    }
}
