package com.example.todoapp.viewmodel

import androidx.activity.viewModels

object ViewModelProvider {
    var topAppBarViewModel: TopAppBarViewModel? = null
        get() = field!!
    var todoAppViewModel: TodoAppViewModel? = null
        get() = field!!
    var todoFormViewModel: TodoFormViewModel? = null
        get() = field!!
}