package com.example.todoapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.db.TodoDao
import com.example.todoapp.utility.DBState
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

    private val _selectedTodoDetailState: MutableStateFlow<DBState> =
        MutableStateFlow(DBState.NotStarted)


    fun handleTodoChange(id: Int) {
        _selectedTodoId.value = id
        getSelectedTodo()
    }

    fun handleCancelTodoDetails() {
        _selectedTodoId.value = -1
        _selectedTodoDetailState.value = DBState.NotStarted
    }

    @Synchronized
    fun getSelectedTodo(todoId: Int = _selectedTodoId.value): StateFlow<DBState> {
        if (todoId != _selectedTodoId.value) {
            _selectedTodoId.value = todoId
            _selectedTodoDetailState.value = DBState.NotStarted
        }
        if (_selectedTodoDetailState.value is DBState.NotStarted) {
            _selectedTodoDetailState.value = DBState.Progressing
            viewModelScope.launch(Dispatchers.IO) {
                try {
                    todoDao.getTodoDetail(_selectedTodoId.value).collect {
                        _selectedTodoDetailState.value = DBState.FetchTodoSuccessfully(it)
                    }
                } catch (e: Exception) {
                    _selectedTodoDetailState.value = DBState.Error(e)
                }
            }
        }
        return _selectedTodoDetailState.asStateFlow()
    }
}