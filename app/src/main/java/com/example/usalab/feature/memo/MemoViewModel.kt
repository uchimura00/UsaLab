package com.example.usalab.feature.memo

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.usalab.core.ScreenState
import com.example.usalab.core.database.entity.MemoEntity
import com.example.usalab.domain.useCase.MemoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MemoViewModel @Inject constructor(
    private val memoUseCase: MemoUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _uiState = MutableStateFlow(MemoState())
    val uiState = _uiState.asStateFlow()

    private val memoId: Int? = savedStateHandle["memoId"]

    init {
        _uiState.update {
            it.copy(memoId = memoId)
        }
        getMemo()
        _uiState.update {
            it.copy(screenState = ScreenState.Success())
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

    private fun getMemo() {
        val id = memoId ?: return
        viewModelScope.launch {
            memoUseCase.getItemStream(id = id).collect { newData ->
                _uiState.update {
                    it.copy(
                        title = newData?.title.orEmpty(),
                        time = newData?.time.orEmpty(),
                        text = newData?.text.orEmpty(),
                        photoUri = newData?.photoUri.orEmpty()
                    )
                }
            }
        }
    }

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