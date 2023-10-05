package com.example.todoapp.utility

import com.example.todoapp.module.Todo

sealed class TodoDetailsFindState {
    object NotStarted : TodoDetailsFindState()
    class Completed(val todo: Todo) : TodoDetailsFindState()
    class Error(val error: Exception) : TodoDetailsFindState()
    object Running : TodoDetailsFindState()
}
