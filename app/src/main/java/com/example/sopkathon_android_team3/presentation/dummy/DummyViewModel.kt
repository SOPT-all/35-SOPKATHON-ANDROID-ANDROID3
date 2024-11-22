package com.example.sopkathon_android_team3.presentation.dummy

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sopkathon_android_team3.data.ServicePool
import com.example.sopkathon_android_team3.data.dto.request.RequestDummyDto
import com.example.sopkathon_android_team3.data.dto.response.ResponseDummyDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DummyViewModel : ViewModel() {

    private val dummyService by lazy { ServicePool.dummyService }

    private val _responseState = MutableStateFlow<ResponseDummyDto?>(null)
    val responseState = _responseState.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage = _errorMessage.asStateFlow()

    fun postDummy(id: String) {
        viewModelScope.launch {
            runCatching {
                dummyService.postDummy(RequestDummyDto(id))
            }.onSuccess { response ->
                _responseState.value = response
            }.onFailure { throwable ->
                _errorMessage.value = throwable.message
            }
        }
    }

    fun getDummy(query: Int) {
        viewModelScope.launch {
            runCatching {
                dummyService.getDummy(query)
            }.onSuccess { response ->
                _responseState.value = response
            }.onFailure { throwable ->
                _errorMessage.value = throwable.message
            }
        }
    }
}