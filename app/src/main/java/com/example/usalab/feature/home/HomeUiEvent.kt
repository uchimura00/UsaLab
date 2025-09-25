package com.example.usalab.feature.home

import com.example.usalab.core.database.entity.MemoEntity

sealed interface HomeUiEvent {
    data object DeleteEnable: HomeUiEvent
    data class DeleteMemo(val memo: MemoEntity): HomeUiEvent

}