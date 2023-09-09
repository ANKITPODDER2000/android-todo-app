package com.example.todoapp.db

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.todoapp.module.Todo
import com.example.todoapp.utility.DataBaseConst.TODO_TABLE_NAME
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Upsert
    suspend fun insertTodo(todo: Todo)

    @Query("DELETE FROM $TODO_TABLE_NAME WHERE id=:deletedId")
    suspend fun deleteTodo(deletedId: Int)

    @Query("DELETE FROM $TODO_TABLE_NAME")
    suspend fun deleteAllTodo()

    @Query("SELECT * FROM $TODO_TABLE_NAME")
    fun getAllTodo(): Flow<List<Todo>>

    @Query("SELECT * FROM $TODO_TABLE_NAME WHERE title =:searchedTodo")
    fun getSearchedTodo(searchedTodo: String): Flow<List<Todo>>
}