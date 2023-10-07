package com.example.todoapp.db

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.todoapp.module.Todo
import com.example.todoapp.utility.DataBaseConst.TODO_TABLE_NAME
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    // This method will perform insert as well as update operation
    @Upsert
    suspend fun insertTodo(todo: Todo)

    // This method will delete a particular todo
    @Query("DELETE FROM $TODO_TABLE_NAME WHERE id=:deletedId")
    suspend fun deleteTodo(deletedId: Int)

    // This method will delete all records of todo table
    @Query("DELETE FROM $TODO_TABLE_NAME")
    suspend fun deleteAllTodo()

    // Fetch all todos from the database
    @Query("SELECT * FROM $TODO_TABLE_NAME")
    fun getAllTodo(): Flow<List<Todo>>

    // Will search for a particular todo
    @Query("SELECT * FROM $TODO_TABLE_NAME WHERE title =:searchedTodo")
    fun getSearchedTodo(searchedTodo: String): Flow<List<Todo>>

    // Will search for a particular todo
    @Query("SELECT * FROM $TODO_TABLE_NAME WHERE id =:selectedId")
    fun getTodoDetail(selectedId: Int) : Flow<Todo>
}
