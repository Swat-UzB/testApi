package com.example.testapi.repository

import com.example.testapi.api.RetrofitInstance
import com.example.testapi.data.APIResult
import org.json.JSONObject
import retrofit2.Response


class Repository {

    suspend fun searchForRestaurant(user_key:String): Response<APIResult> {
      return  RetrofitInstance.api.searchForRestaurant(user_key)
    }
}