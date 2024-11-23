package com.example.sopkathon_android_team3.presentation.type

import androidx.annotation.RawRes
import com.example.sopkathon_android_team3.R

enum class CrystalAnimation(val count: Int, @RawRes val jsonFileName: Int) {
    CRYSTAL_ANIMATION_ZERO(1, R.raw.lotot),
    CRYSTAL_ANIMATION_ONE(1, R.raw.lotot),
    CRYSTAL_ANIMATION_TWO(2, R.raw.lotot),
    CRYSTAL_ANIMATION_THREE(3, R.raw.lotot),
    CRYSTAL_ANIMATION_FOUR(1, R.raw.lotot),
    CRYSTAL_ANIMATION_FIVE(2, R.raw.lotot),
    CRYSTAL_ANIMATION_SIX(3, R.raw.lotot),
    CRYSTAL_ANIMATION_SEVEN(1, R.raw.lotot),
    CRYSTAL_ANIMATION_EIGHT(2, R.raw.lotot);

    companion object {
        fun fromCount(count: Int): CrystalAnimation {
            return entries.find { it.count == count }
                ?: CRYSTAL_ANIMATION_ZERO
        }
    }
}