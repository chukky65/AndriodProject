package com.chuks.houserental.model

import android.accounts.AuthenticatorDescription
import android.icu.text.CaseMap
import com.google.gson.annotations.SerializedName

data class Property (
    @SerializedName( " proprtyPrice")
    val propertyPrice : String,
    @SerializedName( " properrtyDescription")
    val propertyDescription: String,
    @SerializedName("numberOfRooms")
    val numberOfRooms : Int,
    @SerializedName("prpertyStatus")
    val propertyStatus: String,
    @SerializedName(" carPark")
    val carPark: Boolean,
    @SerializedName(" addedDate")
    val addedDate: String,
    @SerializedName("id")
    val id : String,
    @SerializedName("title")
    val title: String,
    @SerializedName("prpertyType")
    val propertyType: String,
    @SerializedName(" landmark")
    val landmark: String,
    @SerializedName(" city")
    val city: String,
    @SerializedName("userId")
    val userId: String
)
