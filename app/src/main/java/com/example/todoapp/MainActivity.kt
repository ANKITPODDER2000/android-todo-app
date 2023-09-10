package com.example.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.todoapp.ui.screen.TodoAppScreen
import com.example.todoapp.ui.theme.TodoappTheme
import com.example.todoapp.viewmodel.TodoAppViewModel
import com.example.todoapp.viewmodel.TopAppBarViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val topAppBarViewModel: TopAppBarViewModel by viewModels()
    private val todoAppViewModel: TodoAppViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            todoAppViewModel.getAllTodo()
            TodoappTheme {
                TodoAppScreen(topAppBarViewModel, todoAppViewModel)
            }
        }
    }
}
