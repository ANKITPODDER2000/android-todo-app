package com.example.todoapp.ui.screen.topappbar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.todoapp.ui.theme.scaffoldContainerColor
import com.example.todoapp.ui.theme.scaffoldContentColor
import com.example.todoapp.utility.NavScreens
import com.example.todoapp.viewmodel.TopAppBarViewModel

@OptIn(ExperimentalMaterial3Api::class)
val appBarColors: TopAppBarColors
    @Composable get() = TopAppBarDefaults.smallTopAppBarColors(
        containerColor = MaterialTheme.colorScheme.scaffoldContainerColor,
        titleContentColor = MaterialTheme.colorScheme.scaffoldContentColor,
        actionIconContentColor = MaterialTheme.colorScheme.scaffoldContentColor
    )

@Composable
fun TodoTopBar(
    topAppBarViewModel: TopAppBarViewModel,
    navHostController: NavHostController,
) {
    val isSearchBarVisible by topAppBarViewModel.isSearchBarVisible.collectAsState()
    val searchedText by topAppBarViewModel.searchedText.collectAsState()
    val currentBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route
    if (isSearchBarVisible && currentRoute == NavScreens.TODO_LIST_PAGE.name) {
        TodoSearchAppBar(searchedText, { topAppBarViewModel.handleSearchedTextChange(it) }) {
            topAppBarViewModel.toggleSearchAppBar()
        }
    } else {
        TodoTopAppBar(navHostController) {
            topAppBarViewModel.toggleSearchAppBar()
        }
    }
}