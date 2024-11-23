package com.example.sopkathon_android_team3.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseBeadContent(
    @SerialName("status")
    val status : Int,
    @SerialName("message")
    val message : Int,
    @SerialName("data")
    val data : BeadCount
)
@Serializable
data class BeadCount(
    @SerialName("count")
    val count: Int
)
