package com.example.usalab.feature.memo

import com.example.usalab.core.ScreenState
import com.example.usalab.core.database.entity.MemoEntity


data class MemoState(
    val screenState: ScreenState = ScreenState.Initializing(),
    val memoList: List<MemoEntity> = emptyList(),
    val title: String = "",
    val time: String = "",
    val text: String = "",
    val photoUri: String = ""
)

//fun MemoListState.toMemo(): MemoEntity = MemoEntity(
//    id = id,
//    title = title,
//    time = time,
//    text = text,
//    photoUri = photoUri
//)
//
//
//fun MemoEntity.toMemoState(isEntryValid: Boolean = false): MemoState = MemoState(
//    memoList = this.toMemoListState(),
//)
//
//fun MemoEntity.toMemoListState(): MemoListState = MemoListState(
//    id = id,
//    title = title,
//    time = time,
//    text = text,
//    photoUri = photoUri
//)

