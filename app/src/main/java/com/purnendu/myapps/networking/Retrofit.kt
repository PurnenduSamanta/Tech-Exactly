package com.sunanda.labassessment.networking

import com.purnendu.myapps.networking.API
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object Retrofit {
    val retrofitInstance: API by lazy {

        val client = OkHttpClient.Builder()
            .callTimeout(300, TimeUnit.SECONDS)
            .connectTimeout(200, TimeUnit.SECONDS)
            .readTimeout(200, TimeUnit.SECONDS)
            .writeTimeout(200, TimeUnit.SECONDS)
            .build()   //Timeout is 60 seconds

        Retrofit.Builder()
            .baseUrl("https://navkiraninfotech.com/g-mee-api/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(API::class.java)
    }

}