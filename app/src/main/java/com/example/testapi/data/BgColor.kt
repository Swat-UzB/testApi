package com.example.testapi.data


import com.google.gson.annotations.SerializedName

data class BgColor(
    @SerializedName("tint")
    val tint: String,
    @SerializedName("type")
    val type: String
)