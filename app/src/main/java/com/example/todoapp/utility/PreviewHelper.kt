package com.example.todoapp.utility

import com.example.todoapp.module.Todo
import kotlin.random.Random

val getTodo: Todo
    get() {
        var taskPriority = TaskPriority.NONE
        val randomNumber = Random.nextInt(0, 3)
        taskPriority = when(randomNumber) {
            0 -> TaskPriority.HIGH
            1 -> TaskPriority.MEDIUM
            2 -> TaskPriority.LOW
            else -> TaskPriority.NONE
        }
        return Todo(
            0,
            "My Todo ${Random.nextInt(1, 20)}",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with",
            "10-10-2023",
            "10-10-2023",
            "10-10-2023",
            false,
            priority = taskPriority
        )
    }
val getTodoItems: List<Todo>
    get() {
        val listOfTodo = mutableListOf<Todo>()
        for(i in 1 .. 4) listOfTodo.add(getTodo)
        return listOfTodo
    }