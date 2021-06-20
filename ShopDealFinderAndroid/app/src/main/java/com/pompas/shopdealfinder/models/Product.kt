package com.pompas.shopdealfinder.models

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("discount")
    val discount : Double,
    @SerializedName("image")
    val image : String)