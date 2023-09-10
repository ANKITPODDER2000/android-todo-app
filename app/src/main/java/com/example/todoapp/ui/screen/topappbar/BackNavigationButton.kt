package com.example.todoapp.ui.screen.topappbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.todoapp.R
import com.example.todoapp.ui.theme.scaffoldContentColor

@Composable
fun BackNavigationButton(backButtonClickListener: () -> Unit) {
    IconButton(onClick = { backButtonClickListener() }) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = stringResource(R.string.back_action_button),
            tint = MaterialTheme.colorScheme.scaffoldContentColor
        )
    }
}