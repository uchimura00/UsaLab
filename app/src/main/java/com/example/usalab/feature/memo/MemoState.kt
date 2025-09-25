package com.example.usalab.feature.memo

import com.example.usalab.core.ScreenState
import com.example.usalab.core.database.entity.MemoEntity


data class MemoState(
    val screenState: ScreenState = ScreenState.Initializing(),
    val memoData: (MemoEntity)? = null,
    val title: String = "",
    val time: String = "",
    val text: String = "",
    val photoUri: String = "",
    val memoId: Int? = null,
)


