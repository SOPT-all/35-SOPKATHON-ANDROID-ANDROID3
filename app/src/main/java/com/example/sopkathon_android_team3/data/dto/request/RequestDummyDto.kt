package com.example.sopkathon_android_team3.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestDummyDto(
    @SerialName("id")
    val id: String,
)
