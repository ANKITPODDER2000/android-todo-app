package com.example.todoapp.viewmodel

import android.util.Log
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
class TodoAppViewModel @Inject constructor(
    private val todoDao: TodoDao,
) : ViewModel() {
    private val _dbState: MutableStateFlow<DBState> = MutableStateFlow(DBState.NotStarted)
    val dbState: StateFlow<DBState>
        get() = _dbState.asStateFlow()

    fun getAllTodo() {
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("DEBUG_ANKIT", "getAllTodo: is called")
            _dbState.value = DBState.Progressing
            try {
                todoDao.getAllTodo().collect {
                    _dbState.value = DBState.Completed(it)
                }
            } catch (error: Exception) {
                _dbState.value = DBState.Error(error)
            }
        }
    }

}