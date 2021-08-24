package com.chuks.houserental.Api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Api_Provider {
    private val interceptor = HttpLoggingInterceptor().also {
        it.setLevel(HttpLoggingInterceptor.Level.BASIC)
    }

    private val client =
        OkHttpClient.Builder().addInterceptor(interceptor)
            .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://ict-yep.herokuapp.com/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    val apiProvider = retrofit.create(ApiService::class.java)
}