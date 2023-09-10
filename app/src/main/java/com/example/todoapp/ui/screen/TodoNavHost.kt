package com.example.todoapp.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.todoapp.ui.screen.todoform.TodoForm
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
            Log.d("DEBUG_ANKIT", "TodoNavHost: todo app details page is called and backStack is : ${navController.previousBackStackEntry != null}")
            TodoDetailsScreen()
        }
        composable(
            route = NavScreens.TODO_FORM.name,
        ) {
            TodoForm()
        }
    }
}

@Composable
fun TodoDetailsScreen() {
    Text(text = "Todo Details Screen")
}
