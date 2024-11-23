package com.example.sopkathon_android_team3.data.service

import com.example.sopkathon_android_team3.data.dto.response.ResponseTotalKingBeadDto
import retrofit2.http.GET
import retrofit2.http.Header

interface TotalKingBeadService {
    @GET("/kingbeads")
    suspend fun getTotalKingBead(
        @Header("userId") userId: Long,
    ): ResponseTotalKingBeadDto
}