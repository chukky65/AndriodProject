package com.chuks.houserental.Api

import com.chuks.houserental.model.User
import retrofit2.http.GET

interface ApiService {
    @GET("Users")
    suspend fun getUsers(): List<User>
}

