package com.example.sopkathon_android_team3.presentation.type

import androidx.annotation.RawRes
import com.example.sopkathon_android_team3.R

enum class CrystalAnimation(val count: Int, @RawRes val jsonFileName: Int) {
    CRYSTAL_ANIMATION_ZERO(0, R.raw.p0),
    CRYSTAL_ANIMATION_ONE(1, R.raw.p1),
    CRYSTAL_ANIMATION_TWO(2, R.raw.p2),
    CRYSTAL_ANIMATION_THREE(3, R.raw.p3),
    CRYSTAL_ANIMATION_FOUR(4, R.raw.p0),
    CRYSTAL_ANIMATION_FIVE(5, R.raw.p0),
    CRYSTAL_ANIMATION_SIX(6, R.raw.p0),
    CRYSTAL_ANIMATION_SEVEN(7, R.raw.p0),
    CRYSTAL_ANIMATION_EIGHT(8, R.raw.p0);

    companion object {
        fun fromCount(count: Int): CrystalAnimation {
            return entries.find { it.count == count }
                ?: CRYSTAL_ANIMATION_ZERO
        }
    }
}