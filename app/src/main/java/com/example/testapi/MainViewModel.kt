package com.example.testapi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapi.data.APIResult
import com.example.testapi.repository.Repository
import com.google.gson.JsonObject
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {
      val myResponse: MutableLiveData<Response<APIResult>> = MutableLiveData()

    fun searchForRestaurant(user_key: String) {
        viewModelScope.launch {
            val response= repository.searchForRestaurant(user_key)
            myResponse.value = response
        }
    }
}