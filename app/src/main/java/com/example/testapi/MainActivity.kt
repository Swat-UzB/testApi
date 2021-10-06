package com.example.testapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.testapi.adapter.RestaurantAdapter
import com.example.testapi.databinding.ActivityMainBinding
import com.example.testapi.repository.Repository
import com.example.testapi.util.Constants.Companion.USER_KEY


class MainActivity : AppCompatActivity() {
    private val restAdapter: RestaurantAdapter by lazy { RestaurantAdapter() }
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.searchForRestaurant(USER_KEY)
        viewModel.myResponse.observe(this, Observer { response ->
            if (response.isSuccessful) {
                Log.d(TAG, response.body()?.resultsFound.toString())
                Log.d(TAG, response.body()?.restaurants?.size.toString())
                binding.resultsAmount.text = "results: " + response.body()?.resultsFound.toString()

                restAdapter.setData(response.body()?.restaurants)
            } else {
                Log.d(TAG, response.errorBody().toString())
                binding.resultsAmount.text = response.code().toString()
            }
        })
        binding.searchResultList.apply {
            adapter = restAdapter
            layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        }
    }

    companion object {
        private const val TAG = "response"
    }
}