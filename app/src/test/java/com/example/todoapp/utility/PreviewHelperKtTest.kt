package com.example.todoapp.utility

import org.junit.Assert.*

import org.junit.Test

class PreviewHelperKtTest {

    @Test
    fun getGetTodo() {
        val todo = getTodo

        assertNotNull(todo)
        assertNotNull(todo.id)
        assertNotNull(todo.title)
        assertNotNull(todo.description)
        assertNotNull(todo.endDate)
        assertNotNull(todo.priority)
        assertNotNull(todo.isCompleted)
        assertNotNull(todo.startDate)
        assertNotNull(todo.targetedEndDate)
    }
}