package com.chuks.houserental.model

data class ApiResponse(
    val count: Int,
    val data: List<Data>,
    val message: String,
    val status: String
)