package com.pompas.shopdealfinder.data

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ProductService {

    //val client by lazy {}
    val client: ProductServiceAPI =
        Retrofit.Builder()
            .baseUrl(Config.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(ProductServiceAPI::class.java)


}