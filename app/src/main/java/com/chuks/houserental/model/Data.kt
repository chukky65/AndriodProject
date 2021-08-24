package com.chuks.houserental.model

data class Data(
    val _id: String,
    val addedDate: String,
    val carPark: Boolean,
    val city: String,
    val landmark: String,
    val numberOfRooms: Int,
    val propertyDescription: String,
    val propertyImages: List<String>,
    val propertyPrice: Int,
    val propertyStatus: String,
    val propertyType: String,
    val title: String,
    val userId: String
)