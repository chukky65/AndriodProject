package com.chuks.houserental.model

import android.net.Uri
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    val id: Int,
    @SerializedName("username")
    val username:String,
    @SerializedName("email")
    val email: String,
    //@SerializedName(" image")
   // val image: String
)
