package com.example.todoapp.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.todoapp.ui.screen.tododetails.TodoDetailsScreen
import com.example.todoapp.ui.screen.todoform.TodoForm
import com.example.todoapp.utility.NavScreens
import com.example.todoapp.viewmodel.TodoAppDetailViewModel
import com.example.todoapp.viewmodel.TodoAppViewModel
import com.example.todoapp.viewmodel.TodoFormViewModel

@Composable
fun TodoNavHost(
    todoAppViewModel: TodoAppViewModel,
    todoFormViewModel: TodoFormViewModel,
    todoAppDetailViewModel: TodoAppDetailViewModel,
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = NavScreens.TODO_LIST_PAGE.name,
        modifier = modifier.fillMaxSize(1f)
    ) {
        composable(NavScreens.TODO_LIST_PAGE.name) {
            TodoListScreen(todoAppViewModel) { todoId ->
                todoAppDetailViewModel.handleTodoChange(todoId)
                navController.navigate("${NavScreens.TODO_DETAILS_PAGE.name}/$todoId")
            }
        }
        composable(
            route = "${NavScreens.TODO_DETAILS_PAGE.name}/{id}",
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) {
            Log.d(
                "DEBUG_ANKIT",
                "TodoNavHost: todo app details page is called and backStack is : ${navController.previousBackStackEntry != null}"
            )
            TodoDetailsScreen(todoAppDetailViewModel ,it.arguments?.getString("id")) {
                todoAppDetailViewModel.handleCancelTodoDetails()
                navController.navigate(NavScreens.TODO_LIST_PAGE.name)
            }
        }
        composable(
            route = NavScreens.TODO_FORM.name,
        ) {
            TodoForm(todoFormViewModel)
        }
    }
}