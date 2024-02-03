package com.example.myapp

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MainClient {
    private val client =  OkHttpClient.Builder()
        .addInterceptor(OAuthInterceptor("Bearer", Utils.Token))
        .build()

    val gson = GsonBuilder()
        .setLenient()
        .create()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://mmfinfotech.co/machine_test/api/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
}