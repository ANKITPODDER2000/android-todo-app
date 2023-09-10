package com.example.todoapp.ui.screen.topappbar

import com.example.todoapp.utility.NavScreens

object TopAppBarHelper {
    fun getAppBarTitle(currentRoute: String?): String {
        return when(currentRoute) {
            NavScreens.TODO_LIST_PAGE.name -> "Todo Task"
            "${NavScreens.TODO_DETAILS_PAGE.name}/{id}" -> "Todo Details"
            NavScreens.TODO_FORM.name ->  "Add Task"
            else -> "Todo App"
        }
    }
}