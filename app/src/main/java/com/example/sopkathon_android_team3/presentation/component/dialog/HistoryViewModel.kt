package com.example.sopkathon_android_team3.presentation.component.dialog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sopkathon_android_team3.data.ServicePool
import com.example.sopkathon_android_team3.data.dto.response.ResponseRandomBeadContent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber

class HistoryViewModel : ViewModel() {
    private val beadDataService by lazy { ServicePool.beadDataService }

    private val _beadDataState = MutableStateFlow<ResponseRandomBeadContent?>(null)
    val beadDataState get() = _beadDataState

    fun getRandomBeadContent(userId: Long) {
        viewModelScope.launch {
            _beadDataState.value = null
            runCatching {
                beadDataService.getRandomBeadContent(1)
            }.onSuccess { response ->
                _beadDataState.value = response
            }.onFailure { error ->
                Timber.tag("getRandomBeadContent error").e(error.message.toString())
            }
        }
    }
}