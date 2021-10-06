package com.example.testapi.data


import com.google.gson.annotations.SerializedName

data class Review(
    @SerializedName("review")
    val review: List<Any>
)