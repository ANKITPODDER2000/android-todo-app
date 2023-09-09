package com.example.todoapp.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todoapp.R
import com.example.todoapp.ui.theme.scaffoldContainerColor
import com.example.todoapp.ui.theme.scaffoldContentColor
import com.example.todoapp.viewmodel.TopAppBarViewModel

@OptIn(ExperimentalMaterial3Api::class)
val appBarColors: TopAppBarColors
    @Composable get() = TopAppBarDefaults.smallTopAppBarColors(
        containerColor = MaterialTheme.colorScheme.scaffoldContainerColor,
        titleContentColor = MaterialTheme.colorScheme.scaffoldContentColor,
        actionIconContentColor = MaterialTheme.colorScheme.scaffoldContentColor
    )

@Composable
fun TodoTopBar(topAppBarViewModel: TopAppBarViewModel, appBarTitle: String) {
    val isSearchBarVisible by topAppBarViewModel.isSearchBarVisible.collectAsState()
    val searchedText by topAppBarViewModel.searchedText.collectAsState()
    if (!isSearchBarVisible) TodoTopAppBar(appBarTitle) {
        topAppBarViewModel.toggleSearchAppBar()
    }
    else TodoSearchAppBar(searchedText, { topAppBarViewModel.handleSearchedTextChange(it) }) {
        topAppBarViewModel.toggleSearchAppBar()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoSearchAppBar(
    inputText: String,
    handleInputChange: (String) -> Unit,
    toggleSearchBar: () -> Unit,
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth(1f)
            .height(64.dp),
        shadowElevation = 4.dp,
        color = MaterialTheme.colorScheme.scaffoldContainerColor,

    ) {
        TextField(
            value = inputText,
            onValueChange = { handleInputChange(it) },
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.scaffoldContainerColor),
            leadingIcon = {
                IconButton(onClick = {
                    /* Todo */
                }) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = stringResource(R.string.search_button_to_do_perform_search),
                        tint = MaterialTheme.colorScheme.scaffoldContentColor
                    )
                }
            },
            placeholder = {
                Text(
                    text = "Search",
                    modifier = Modifier.alpha(0.7f),
                    color = MaterialTheme.colorScheme.scaffoldContentColor
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                textColor = MaterialTheme.colorScheme.scaffoldContentColor,
                cursorColor = MaterialTheme.colorScheme.scaffoldContentColor,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                containerColor = Color.Transparent
            ),
            trailingIcon = {
                IconButton(onClick = {
                    if (inputText == "") toggleSearchBar()
                }, modifier = Modifier.alpha(0.6f)) {
                    Icon(
                        imageVector = if (inputText.isNotEmpty()) Icons.Outlined.ArrowForward else Icons.Filled.Clear,
                        contentDescription = stringResource(R.string.clear_text_filled),
                        tint = MaterialTheme.colorScheme.scaffoldContentColor
                    )
                }
            },
            maxLines = 1,
            singleLine = true
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoTopAppBar(appBarTitle: String, handleSearchButtonClicked: () -> Unit) {
    TopAppBar(title = { Text(text = appBarTitle) },
        colors = appBarColors,
        navigationIcon = { NavigationButton() },
        actions = {
            SearchButton(handleSearchButtonClicked)
            SortButton()
            DeleteButton()
        })
}

@Composable
fun NavigationButton() {
    IconButton(onClick = { /*TODO*/ }) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = stringResource(R.string.back_action_button),
            tint = MaterialTheme.colorScheme.scaffoldContentColor
        )
    }
}

@Preview(name = "Light Preview")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark Preview")
@Composable
fun PreviewTodoTopSearchBar() {
    TodoSearchAppBar("", {}) {}
}

@Preview(name = "Light Preview")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark Preview")
@Composable
fun PreviewTodoTopBar() {
    TodoTopBar(TopAppBarViewModel(), "App Title")
}