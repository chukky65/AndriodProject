package com.chuks.houserental.UI

data class Image
    (
val name: String,
val id: Int,
val SecondText: String){
        val imageUrl = "https://picsum.photos/150?random=$id"
    }

