package com.example.sopkathon_android_team3.presentation.home

import androidx.lifecycle.ViewModel
import com.example.sopkathon_android_team3.presentation.type.CrystalAnimation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel:ViewModel() {
    private val _animation = MutableStateFlow(CrystalAnimation.CRYSTAL_ANIMATION_ZERO)
    val animation: StateFlow<CrystalAnimation> = _animation.asStateFlow()

    fun fetchAnimation(count: Int) {
        // 서버에서 받은 count 값으로 Enum 설정
        _animation.update { CrystalAnimation.fromCount(count) }
    }
}