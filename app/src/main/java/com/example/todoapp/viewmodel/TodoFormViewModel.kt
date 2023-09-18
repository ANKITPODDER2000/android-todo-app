package com.example.todoapp.viewmodel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.todoapp.db.TodoDao
import com.example.todoapp.module.Todo
import com.example.todoapp.utility.DBOperationResult
import com.example.todoapp.utility.NavScreens
import com.example.todoapp.utility.TaskPriority
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class TodoFormViewModel @Inject constructor(private val todoDao: TodoDao) : ViewModel() {
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

    private suspend fun formSubmitListener(): DBOperationResult {
        if (_formState.value.title.isEmpty() || _formState.value.description.isEmpty())
            return DBOperationResult.FormNotFilled
        return try {
            todoDao.insertTodo(_formState.value)
            DBOperationResult.Success
        } catch (e: Exception) {
            DBOperationResult.Error(e)
        }
    }

    fun handleFormSubmit(
        context: Context,
        navHostController: NavHostController,
        getAllTodo: () -> Unit,
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            when (val response = formSubmitListener()) {
                is DBOperationResult.FormNotFilled -> {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            context,
                            "Please fill the all text",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                is DBOperationResult.Error -> {
                    Log.e(
                        "DEBUG_ANKIT",
                        "TodoAppScreen: error is : ${response.error.localizedMessage}"
                    )
                }

                else -> {
                    getAllTodo()
                    withContext(Dispatchers.Main) {
                        navHostController.navigate(NavScreens.TODO_LIST_PAGE.name)
                    }
                }
            }
        }
    }
}