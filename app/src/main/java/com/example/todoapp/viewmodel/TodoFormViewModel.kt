package com.example.todoapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todoapp.module.Todo
import com.example.todoapp.utility.TaskPriority
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class TodoFormViewModel @Inject constructor() : ViewModel() {
    private val _formState = MutableStateFlow(Todo("", "", TaskPriority.LOW))
    val formState = _formState.asStateFlow()

    fun updatePriority(priority: TaskPriority) {
        _formState.update {
            it.copy(priority = priority)
        }
    }

    fun updateTodoTitle(title: String) {
        _formState.update {
            it.copy(title = title)
        }
    }

    fun updateTodoDescription(description: String) {
        _formState.update {
            it.copy(description = description)
        }
    }
}