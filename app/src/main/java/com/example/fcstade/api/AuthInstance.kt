package com.example.fcstade.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AuthInstance {
    fun getAuthInstance():Retrofit{
        val gson=GsonBuilder().setLenient().create()
        return Retrofit.Builder()
            .baseUrl("10.0.2.2:8080/api/auth/signin")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}