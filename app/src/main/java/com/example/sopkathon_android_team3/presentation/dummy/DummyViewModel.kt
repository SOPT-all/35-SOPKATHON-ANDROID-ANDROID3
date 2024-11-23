package com.example.sopkathon_android_team3.presentation.dummy

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sopkathon_android_team3.data.ServicePool
import com.example.sopkathon_android_team3.data.dto.request.RequestDummyDto
import com.example.sopkathon_android_team3.data.dto.response.ResponseDummyDto
import kotlinx.coroutines.launch
import timber.log.Timber

class DummyViewModel : ViewModel() {

    private val dummyService by lazy { ServicePool.dummyService }

    private val _dummyState = mutableStateOf<ResponseDummyDto?>(null)
    val dummyState = _dummyState

    fun postDummy(id: String) {
        viewModelScope.launch {
            runCatching {
                dummyService.postDummy(RequestDummyDto(id))
            }.onSuccess { response ->
                _dummyState.value = response
            }.onFailure { error ->
                Timber.tag("postDummy error").e(error.message.toString())
            }
        }
    }

    fun getDummy(query: Int) {
        viewModelScope.launch {
            runCatching {
                dummyService.getDummy(query)
            }.onSuccess { response ->
                _dummyState.value = response
            }.onFailure { error ->
                Timber.tag("getDummy error").e(error.message.toString())
            }
        }
    }
}