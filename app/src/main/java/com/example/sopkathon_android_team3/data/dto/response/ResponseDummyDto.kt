package com.example.sopkathon_android_team3.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseDummyDto(
    @SerialName("code")
    val code: Int,
    @SerialName("message")
    val message: String,
)
