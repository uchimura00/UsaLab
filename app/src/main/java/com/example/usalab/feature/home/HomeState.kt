package com.example.usalab.feature.home

import com.example.usalab.data.model.ToDo

data class HomeState(
    val isLoading: Boolean = false,
    val toDoList: List<ToDo> = listOf(
        ToDo(
            toDoDate = "2024-06-01",
            toDoName = "Sample ToDo 1",
            genre = "This is a sample to-do item.",
            toDoId = 1
        ),
        ToDo(
            toDoDate = "2024-06-01",
            toDoName = "Sample ToDo 1",
            genre = "This is a sample to-do item.",
            toDoId = 1
        ),
        ToDo(
            toDoDate = "2024-06-01",
            toDoName = "Sample ToDo 1",
            genre = "This is a sample to-do item.",
            toDoId = 1
        )
    )
)