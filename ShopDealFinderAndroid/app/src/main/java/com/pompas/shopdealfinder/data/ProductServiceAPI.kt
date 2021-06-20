package com.pompas.shopdealfinder.data

import com.pompas.shopdealfinder.models.Product
import retrofit2.http.GET

interface ProductServiceAPI {

    @GET("/products/foodWaste")
    suspend fun getProducts() : List<Product>

}