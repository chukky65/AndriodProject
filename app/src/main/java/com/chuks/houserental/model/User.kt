package com.chuks.houserental.model

import android.net.Uri
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("data")
    val data: Data,
    @SerializedName("status")
    val status: String
)
