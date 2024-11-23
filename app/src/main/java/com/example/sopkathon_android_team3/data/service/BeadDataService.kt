package com.example.sopkathon_android_team3.data.service

import com.example.sopkathon_android_team3.data.dto.request.RequestBeadContent
import com.example.sopkathon_android_team3.data.dto.request.RequestKingBeadContent
import com.example.sopkathon_android_team3.data.dto.response.ResponseBeadContent
import com.example.sopkathon_android_team3.data.dto.response.ResponseRandomBeadContent
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface BeadDataService {
    @POST("/bead")
    suspend fun postBeadContent(
        @Header("userId") userId: Long,
        @Body request: RequestBeadContent
    ): ResponseBeadContent

    @POST("/kingbead")
    suspend fun postKingBeadContent(
        @Header("userId") userId: Long,
        @Body request: RequestKingBeadContent
    ): ResponseBeadContent

    @GET("/bead")
    suspend fun getRandomBeadContent(
        @Header("userId") userId: Long,
    ): ResponseRandomBeadContent
}