package com.example.todoapp.utility

sealed class DBOperationResult {
    object Success : DBOperationResult()
    class Error(val error: Exception) : DBOperationResult()
    object FormNotFilled : DBOperationResult()
}