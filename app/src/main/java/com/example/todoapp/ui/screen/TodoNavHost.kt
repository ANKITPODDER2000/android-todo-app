package com.example.todoapp.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todoapp.utility.NavScreens
import com.example.todoapp.viewmodel.TodoAppViewModel

@Composable
fun TodoNavHost(todoAppViewModel: TodoAppViewModel, modifier: Modifier = Modifier) {
    NavHost(
        navController = rememberNavController(),
        startDestination = NavScreens.TODO_LIST_PAGE.name,
        modifier = modifier.fillMaxSize(1f)
    ) {
        composable(NavScreens.TODO_LIST_PAGE.name) {
            todoAppViewModel.getAllTodo()
            val todoList by todoAppViewModel.allTodo.collectAsState()
            TodoListScreen(todoList)
        }
    }
}