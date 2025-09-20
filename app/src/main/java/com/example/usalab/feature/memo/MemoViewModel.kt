package com.example.usalab.feature.memo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.usalab.core.database.entity.MemoEntity
import com.example.usalab.domain.useCase.MemoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MemoViewModel @Inject constructor(
    private val memoUseCase: MemoUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(MemoState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            memoUseCase.getAllItemsStream().collect { list ->
                _uiState.update {
                    it.copy(
                        memoList = list
                    )
                }
            }
        }
    }

    fun inputTitle(title: String) {
        _uiState.update { it.copy(title = title) }
    }

    fun inputTime(time: String) {
        _uiState.update { it.copy(time = time) }
    }

    fun inputText(text: String) {
        _uiState.update { it.copy(text = text) }
    }

    fun inputPhotoUri(photoUri: String) {
        _uiState.update { it.copy(photoUri = photoUri) }
    }

    fun getMemo(id: Int) = memoUseCase.getItemStream(id)

    fun saveMemo() {
        val state = uiState.value
        val memo = MemoEntity(
            title = state.title,
            time = state.time,
            text = state.text,
            photoUri = state.photoUri
        )
        viewModelScope.launch {
            memoUseCase.insertItem(memo)
        }
    }

}