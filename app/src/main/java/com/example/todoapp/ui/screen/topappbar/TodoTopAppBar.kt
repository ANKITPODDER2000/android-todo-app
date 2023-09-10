package com.example.todoapp.ui.screen.topappbar

import android.app.Activity
import android.content.res.Configuration
import android.util.Log
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.todoapp.utility.NavScreens

private const val TAG = "TodoHomeTopAppBar"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoTopAppBar(
    navController: NavHostController,
    handleSearchButtonClicked: () -> Unit,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val context = LocalContext.current as Activity
    Log.d(TAG, "TodoTopAppBar: Current route is : $currentRoute")

    val appBarTitle = TopAppBarHelper.getAppBarTitle(currentRoute)
    TopAppBar(title = { Text(text = appBarTitle) },
        colors = appBarColors,
        navigationIcon = {
            BackNavigationButton {
                if (navController.previousBackStackEntry != null)
                    navController.navigateUp()
                else
                    context.finish()
            }
        },
        actions = {
            when (currentRoute) {
                NavScreens.TODO_LIST_PAGE.name -> HomeActionButtons(handleSearchButtonClicked)
                NavScreens.TODO_FORM.name -> DoneButton()
                "${NavScreens.TODO_DETAILS_PAGE.name}/{id}" -> EditButton()
            }
        }
    )
}

@Preview(name = "Light Preview")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark Preview")
@Composable
fun PreviewTodoTopBar() {
    TodoTopAppBar(rememberNavController()) { }
}