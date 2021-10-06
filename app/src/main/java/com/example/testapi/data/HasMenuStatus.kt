package com.example.testapi.data


import com.google.gson.annotations.SerializedName

data class HasMenuStatus(
    @SerializedName("delivery")
    val delivery: Any,
    @SerializedName("takeaway")
    val takeaway: Int
)