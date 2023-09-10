package com.example.todoapp.ui.screen.topappbar

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todoapp.R
import com.example.todoapp.ui.theme.scaffoldContainerColor
import com.example.todoapp.ui.theme.scaffoldContentColor

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


@Preview(name = "Light Preview")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark Preview")
@Composable
fun PreviewTodoTopSearchBar() {
    TodoSearchAppBar("", {}) {}
}