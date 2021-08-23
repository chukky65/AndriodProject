package com.chuks.houserental.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Api_Provider {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiProvider = retrofit.create(ApiService::class.java)
}