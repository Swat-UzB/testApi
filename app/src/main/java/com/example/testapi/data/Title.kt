package com.example.testapi.data


import com.google.gson.annotations.SerializedName

data class Title(
    @SerializedName("text")
    val text: String
)