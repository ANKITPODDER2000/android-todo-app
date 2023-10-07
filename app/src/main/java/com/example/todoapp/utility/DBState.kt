package com.example.todoapp.utility

import com.example.todoapp.module.Todo

sealed class DBState {
    class Error(val error: Exception) : DBState()
    object NotStarted : DBState()
    object Progressing : DBState()
    class FetchAllTodosSuccessfully(val todos: List<Todo>) : DBState()
    class FetchTodoSuccessfully(val todo: Todo) : DBState()
}