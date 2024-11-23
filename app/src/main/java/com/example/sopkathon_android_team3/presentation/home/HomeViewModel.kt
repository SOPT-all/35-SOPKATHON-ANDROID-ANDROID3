package com.example.sopkathon_android_team3.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sopkathon_android_team3.data.ServicePool
import com.example.sopkathon_android_team3.data.ServicePool.beadDataService
import com.example.sopkathon_android_team3.data.dto.request.RequestBeadContent
import com.example.sopkathon_android_team3.presentation.type.CrystalAnimation
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class HomeViewModel : ViewModel() {
    private val beadDataService by lazy { ServicePool.beadDataService }


    private val _animation = MutableStateFlow(CrystalAnimation.CRYSTAL_ANIMATION_ZERO)
    val animation: StateFlow<CrystalAnimation> = _animation.asStateFlow()

    private val _even = MutableStateFlow("")
    val even: StateFlow<String> = _even.asStateFlow()

    private val _ifValue = MutableStateFlow("")
    val ifValue: StateFlow<String> = _ifValue.asStateFlow()

    fun updateEven(evenValue: String) {
        _even.value = evenValue
    }

    fun updateIfValue(ifValue: String) {
        _ifValue.value = ifValue
    }

    fun resetTextField() {
        _even.value = ""
        _ifValue.value = ""

    }

    fun fetchAnimation(count: Int) {
        // 서버에서 받은 count 값으로 Enum 설정
        _animation.update { CrystalAnimation.fromCount(count) }
    }

    fun postBeadContent() {
        viewModelScope.launch {
            runCatching {
                beadDataService.postBeadContent(1, RequestBeadContent(_even.value, _ifValue.value))
            }.onSuccess { response ->
                handleBeadContentResponse(response.data.count)
            }.onFailure { error ->
            }
        }
    }

    private fun handleBeadContentResponse(count: Int) {
        viewModelScope.launch {
            if (count % 8 == 0) {
                _animation.update {
                    CrystalAnimation.fromCount(8)
                }
                delay(4500)
                postKingBeadContent()

            } else {
                _animation.update {
                    CrystalAnimation.fromCount(count % 8)
                }
            }
        }
    }

    private fun postKingBeadContent() {
        viewModelScope.launch {
            runCatching {
                beadDataService.postKingBeadContent(1)
            }.onSuccess { response ->
                _animation.update {
                    CrystalAnimation.fromCount(0)
                }
            }.onFailure { error ->
                Log.d("ㅋㅋ", error.message.toString())
            }
        }
    }
}