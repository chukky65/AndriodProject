package com.chuks.houserental.Api

import com.chuks.houserental.model.ApiResponse
import com.chuks.houserental.model.User
import retrofit2.http.GET

interface ApiService {
    @GET("properties")
    suspend fun getUsers(): ApiResponse
}

