package com.example.usalab.feature.home

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
class HomeViewModel @Inject constructor(
    private val memoUseCase: MemoUseCase
): ViewModel() {
    private val _uiState = MutableStateFlow(HomeState())
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

    fun deleteEnabledChange() {
        _uiState.update {
            it.copy(
                deleteEnabled = !it.deleteEnabled
            )
        }
    }

    fun deleteMemo(memo: MemoEntity) {
        viewModelScope.launch {
            memoUseCase.deleteItem(memo)
        }
    }
}