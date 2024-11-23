package com.example.sopkathon_android_team3.presentation.storage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sopkathon_android_team3.R
import com.example.sopkathon_android_team3.data.dto.response.ResponseBeadContent
import com.example.sopkathon_android_team3.data.service.BeadDataService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class StorageUiState(
    val currentImages: List<Int> = emptyList(),
    val isLeftArrowEnabled: Boolean = false,
    val isRightArrowEnabled: Boolean = false
)

class StorageViewModel(
    private val beadDataService: BeadDataService
) : ViewModel() {

    private val _uiState = MutableStateFlow(StorageUiState())
    val uiState: StateFlow<StorageUiState> = _uiState

    fun loadBeadContent(userId: Long) {
        viewModelScope.launch {
            try {
                val response: ResponseBeadContent = beadDataService.postKingBeadContent(userId)
                val count = response.data.count
                val quotient = count / 8

                when (quotient) {
                    1 -> {
                        _uiState.value = StorageUiState(
                            currentImages = listOf(R.drawable.ic_king_bead_blue_center),
                            isLeftArrowEnabled = false,
                            isRightArrowEnabled = false
                        )
                    }
                    2 -> {
                        _uiState.value = StorageUiState(
                            currentImages = listOf(R.drawable.ic_king_bead_green_center, R.drawable.ic_king_bead_blue_center),
                            isLeftArrowEnabled = true,
                            isRightArrowEnabled = true
                        )
                    }
                    else -> {
                        _uiState.value = StorageUiState(
                            currentImages = emptyList(),
                            isLeftArrowEnabled = false,
                            isRightArrowEnabled = false
                        )
                    }
                }
            } catch (e: Exception) {
                _uiState.value = StorageUiState()
            }
        }
    }

    fun moveLeft() {
        _uiState.value = _uiState.value.copy(
            currentImages = listOf(R.drawable.ic_king_bead_green_center)
        )
    }

    fun moveRight() {
        _uiState.value = _uiState.value.copy(
            currentImages = listOf(R.drawable.ic_king_bead_blue_center)
        )
    }
}
