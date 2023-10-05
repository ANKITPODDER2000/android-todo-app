package com.example.todoapp.viewmodel

import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.db.TodoDao
import com.example.todoapp.utility.TodoDetailsFindState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoAppDetailViewModel @Inject constructor(private val todoDao: TodoDao) : ViewModel() {
    private val _selectedTodoId = MutableStateFlow(-1)
    val selectedTodoId = _selectedTodoId.asStateFlow()

    private val _selectedTodoDetailState: MutableStateFlow<TodoDetailsFindState> =
        MutableStateFlow(TodoDetailsFindState.NotStarted)


    fun handleTodoChange(id: Int) {
        _selectedTodoId.value = id
    }

    fun handleCancelTodoDetails() {
        _selectedTodoId.value = -1
    }

    fun getSelectedTodo(): StateFlow<TodoDetailsFindState> {
        _selectedTodoDetailState.value = TodoDetailsFindState.Running
        viewModelScope.launch(Dispatchers.IO) {
            try {
                todoDao.getTodoDetail(_selectedTodoId.value).collect {
                    _selectedTodoDetailState.value = TodoDetailsFindState.Completed(it)
                }
            } catch (e: Exception) {
                _selectedTodoDetailState.value = TodoDetailsFindState.Error(e)
            }
        }
        return _selectedTodoDetailState.asStateFlow()
    }
}