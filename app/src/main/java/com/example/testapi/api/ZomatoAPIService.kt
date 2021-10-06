package com.example.testapi.api

import com.example.testapi.data.APIResult
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ZomatoAPIService {
    @GET("reviews")
    suspend fun getRestaurantReviews(
        @Header("user-key") user_key: String,
        @Query("res-id") res_id: Int,
        @Query("start") start: Int,
        @Query("count") count: Int
    ): Call<String>

    @GET("search")
    suspend fun searchForRestaurant(
        @Header("user-key") user_key: String,
//        @Query("entity_id") entity_id: Int,
//        @Query("entity_type") entity_type: Array<String>,
//        @Query("q") queryByCityName: String,
//        @Query("lat") latitude: Int,
//        @Query("lon") longitude: Int,
//        @Query("start") start: Int,
//        @Query("count") count: Int,
//        @Query("cuisine") cuisine: String,
//        @Query("radius") radius: Int,
//        @Query("establishment_type") establishment_type: String,
//        @Query("collection_id") collection_id: String,
//        @Query("category") category: String,
//        @Query("sort") sort: Array<String>,
//        @Query("order") order: Array<String>,
    ): Response<APIResult>
}