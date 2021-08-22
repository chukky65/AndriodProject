package com.chuks.houserental.model

import android.net.Uri
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("property")
    val property: Property,
    @SerializedName("status")
    val status: String
)
