package com.example.fcstade.api

import com.example.fcstade.models.*
import retrofit2.Call
import retrofit2.http.*

interface StadiumService {
    @GET("/getAllUsers")
    @Headers("Content-Type: application/json")
    fun getStadiumList(): Call<StadiumList>

    @Headers("Content-Type: application/json")
    @POST("/add")
    fun createStadium(@Body params: Stadium): Call<StadiumResponse>

    @Headers("Content-Type: application/json")
    @DELETE("/{id}")
    fun deleteUser(@Path("name") name: String): Call<StadiumList>

    @PATCH("/update/{id}")
    @Headers("Content-Type: application/json")
    fun updateStadium(@Path("name") name: String,@Body params: Stadium):Call<StadiumResponse>

}