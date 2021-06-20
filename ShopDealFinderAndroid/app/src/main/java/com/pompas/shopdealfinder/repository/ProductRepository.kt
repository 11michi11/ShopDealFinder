package com.pompas.shopdealfinder.repository

import androidx.lifecycle.MutableLiveData
import com.pompas.shopdealfinder.data.ProductService
import com.pompas.shopdealfinder.models.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductRepository {

    private val client = ProductService.client
    val products = MutableLiveData<List<Product>>()

    suspend fun getProducts() {
         withContext(Dispatchers.IO) {
            val response = client.getProducts()
             products.postValue(response)
        }
    }



}