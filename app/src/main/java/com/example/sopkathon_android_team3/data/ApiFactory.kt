package com.example.sopkathon_android_team3.data

import com.example.sopkathon_android_team3.BuildConfig
import com.example.sopkathon_android_team3.data.service.BeadDataService
import com.example.sopkathon_android_team3.data.service.DummyService
import com.example.sopkathon_android_team3.data.service.TotalKingBeadService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

object ApiFactory {
    private const val BASE_URL: String = BuildConfig.BASE_URL

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    val retrofit: Retrofit by lazy {
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .client(client).build()
    }

    inline fun <reified T> create(): T = retrofit.create<T>(T::class.java)
}

object ServicePool {
    val dummyService = ApiFactory.create<DummyService>()
    val totalKingBeadService = ApiFactory.create<TotalKingBeadService>()
    val beadDataService = ApiFactory.create<BeadDataService>()
}