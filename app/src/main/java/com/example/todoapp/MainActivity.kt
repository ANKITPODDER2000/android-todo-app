package com.example.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todoapp.ui.screen.TodoAppScreen
import com.example.todoapp.ui.theme.TodoappTheme
import com.example.todoapp.viewmodel.TodoAppDetailViewModel
import com.example.todoapp.viewmodel.TodoAppViewModel
import com.example.todoapp.viewmodel.TodoFormViewModel
import com.example.todoapp.viewmodel.TopAppBarViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val topAppBarViewModel: TopAppBarViewModel by viewModels() // Create an instance of topAppBarViewModel
    private val todoAppViewModel: TodoAppViewModel by viewModels() // Create an instance of todoAppViewModel
    private val todoFormViewModel: TodoFormViewModel by viewModels() // Create an instance of todoFormViewModel
    private val todoAppDetailViewModel: TodoAppDetailViewModel by viewModels() // Create an instance of todoAppDetailViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        todoAppViewModel.getAllTodo() // Start the operation to fetch the data from the Room data base.
        setContent {
            TodoappTheme {
                TodoAppScreen(topAppBarViewModel, todoAppViewModel, todoFormViewModel, todoAppDetailViewModel)
            }
        }
    }
}
