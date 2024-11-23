package com.example.sopkathon_android_team3.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseTotalKingBeadDto(
    @SerialName("status")
    val status: Int,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: List<KingBead>
)

@Serializable
data class KingBead(
    @SerialName("kingbeadId")
    val kingbeadId: Int,
    @SerialName("imageUrl")
    val imageUrl: String
)


