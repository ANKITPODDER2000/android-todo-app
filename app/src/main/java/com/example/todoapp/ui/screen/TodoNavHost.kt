package com.example.todoapp.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.todoapp.utility.NavScreens
import com.example.todoapp.viewmodel.TodoAppViewModel

@Composable
fun TodoNavHost(todoAppViewModel: TodoAppViewModel, navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = NavScreens.TODO_LIST_PAGE.name,
        modifier = modifier.fillMaxSize(1f)
    ) {
        composable(NavScreens.TODO_LIST_PAGE.name) {
            TodoListScreen(todoAppViewModel) { todoId ->
                navController.navigate("${NavScreens.TODO_DETAILS_PAGE.name}/$todoId")
            }
        }
        composable(
            route = "${NavScreens.TODO_DETAILS_PAGE.name}/{id}",
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) {
            TodoDetailsScreen()
        }
    }
}

@Composable
fun TodoDetailsScreen() {
    Text(text = "Todo Details Screen")
}
