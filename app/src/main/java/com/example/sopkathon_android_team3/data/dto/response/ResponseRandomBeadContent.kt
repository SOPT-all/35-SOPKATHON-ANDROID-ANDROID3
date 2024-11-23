package com.example.sopkathon_android_team3.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseRandomBeadContent(
    @SerialName("status")
    val status: Int,         // 상태 코드
    @SerialName("message")
    val message: String,     // 응답 메시지
    @SerialName("data")
    val data: BeadData       // 구슬 데이터
)

@Serializable
data class BeadData(
    @SerialName("beadId")
    val beadId: Int,         // 구슬 ID
    @SerialName("content1")
    val content1: String,    // 구슬 내용 1
    @SerialName("content2")
    val content2: String     // 구슬 내용 2
)

