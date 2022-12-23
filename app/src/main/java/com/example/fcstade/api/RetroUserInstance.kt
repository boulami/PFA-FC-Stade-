package com.example.fcstade.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroUserInstance {
    companion object{
        val baseUrl=""
        fun getRetroUserInstance():Retrofit{
            val logging =HttpLoggingInterceptor()
            logging.level=(HttpLoggingInterceptor.Level.BODY)
            val client=OkHttpClient.Builder()
            client.addInterceptor(logging)
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

}