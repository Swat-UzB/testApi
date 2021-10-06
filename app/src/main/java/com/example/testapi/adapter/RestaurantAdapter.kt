package com.example.testapi.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testapi.R
import com.example.testapi.data.Restaurant
import com.example.testapi.databinding.ResultItemBinding
import com.squareup.picasso.Picasso

class RestaurantAdapter() :
    RecyclerView.Adapter<RestaurantAdapter.RestViewHolder>() {
    private var datalist = emptyList<Restaurant>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(restaurantData: List<Restaurant>?) {
        if (restaurantData != null) {
            datalist = restaurantData
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestViewHolder {
        val binding = ResultItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RestViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RestViewHolder, position: Int) {
        holder.bindData(datalist[position])
    }

    override fun getItemCount() = datalist.size

    class RestViewHolder(private val binding: ResultItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(restaurantData: Restaurant) {
            if (restaurantData.restaurant.thumb.isNotEmpty()) {
                Picasso.get()
                    .load(restaurantData.restaurant.thumb)
                    .into(binding.imageRestaurant)
            } else {
                binding.imageRestaurant.setImageResource(R.drawable.ic_no_photography)
            }
            Log.d("response", restaurantData.restaurant.thumb)
            binding.resName.text = restaurantData.restaurant.name
            binding.cuisines.text = restaurantData.restaurant.cuisines
            binding.averageCostForTwo.text = restaurantData.restaurant.averageCostForTwo.toString()
                .plus(" ${restaurantData.restaurant.currency}")
            binding.workTime.text = restaurantData.restaurant.timings
            binding.phoneNumbers.text = restaurantData.restaurant.phoneNumbers
            binding.openWebSite.setOnClickListener {
                val uri = Uri.parse(restaurantData.restaurant.url)
                it.context.startActivity(Intent(Intent.ACTION_VIEW, uri))
            }
        }
    }
}