package com.example.usalab.feature.memo

sealed interface MemoUiEvent {
    data class InputTitle(val title: String) : MemoUiEvent
    data class InputTime(val time: String) : MemoUiEvent
    data class InputText(val text: String) : MemoUiEvent
    data class InputPhotoUri(val photoUri: String) : MemoUiEvent
    object Save : MemoUiEvent
}