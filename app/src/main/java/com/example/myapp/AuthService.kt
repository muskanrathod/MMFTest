package com.example.myapp

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface AuthService {
    @POST("userLogin")
    fun login(@Body loginRequest: LoginRequest): Call<Login>
}
