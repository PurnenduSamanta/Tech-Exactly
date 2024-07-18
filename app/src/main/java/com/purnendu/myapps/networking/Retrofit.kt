package com.purnendu.myapps.networking

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object Retrofit {
    val retrofitInstance: API by lazy {

        val client = OkHttpClient.Builder()
            .build()

        Retrofit.Builder()
            .baseUrl("https://navkiraninfotech.com/g-mee-api/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(API::class.java)
    }

}