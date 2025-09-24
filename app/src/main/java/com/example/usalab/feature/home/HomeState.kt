package com.example.usalab.feature.home

import com.example.usalab.core.ScreenState
import com.example.usalab.core.database.entity.MemoEntity

data class HomeState(
    val isLoading: Boolean = false,
    val screenState: ScreenState = ScreenState.Initializing(),
    val memoList: List<MemoEntity> = emptyList(),
    val deleteEnabled: Boolean = false,
)

data class MemoListState(
    val id: Int = 0,
    val title: String = "",
    val time: String = "",
    val text: String = "",
    val photoUri: String = ""
)