package com.chuks.houserental.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Api_Provider {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://ict-yep.herokuapp.com/api/v1/properties/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiProvider = retrofit.create(ApiService::class.java)
}