package com.example.sopkathon_android_team3.data.service

import com.example.sopkathon_android_team3.data.dto.request.RequestDummyDto
import com.example.sopkathon_android_team3.data.dto.response.ResponseDummyDto
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface DummyService {
    @POST("/post")
    suspend fun postDummy(
        requestDummyDto: RequestDummyDto,
    ): ResponseDummyDto

    @GET("/get")
    suspend fun getDummy(
        @Query("query") query: Int,
    ): ResponseDummyDto
}