package com.example.myapp

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface MainService {
    @GET("userList")
    fun getUserList(): Call<ListResponse>
}
