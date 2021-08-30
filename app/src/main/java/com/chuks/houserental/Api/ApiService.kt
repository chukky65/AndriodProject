package com.chuks.houserental.Api

import com.chuks.houserental.model.PropertiesResponse
import retrofit2.http.*

interface ApiService {
    @GET("properties")
    suspend fun getUsers(): PropertiesResponse
}

