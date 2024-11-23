package com.example.sopkathon_android_team3.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestBeadContent(
    @SerialName("content1")
    val content1: String,
    @SerialName("content2")
    val content2: String
)
