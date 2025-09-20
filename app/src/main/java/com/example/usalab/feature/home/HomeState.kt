package com.example.usalab.feature.home

import com.example.usalab.core.ScreenState
import com.example.usalab.core.database.entity.MemoEntity
import com.example.usalab.data.model.ToDo

data class HomeState(
    val isLoading: Boolean = false,
    val screenState: ScreenState = ScreenState.Initializing(),
    val memoList: List<MemoEntity> = emptyList(),
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

data class MemoListState(
    val id: Int = 0,
    val title: String = "",
    val time: String = "",
    val text: String = "",
    val photoUri: String = ""
)