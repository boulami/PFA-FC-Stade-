package com.example.fcstade.api

import com.example.fcstade.models.*
import retrofit2.Call
import retrofit2.http.*

interface StadeApi {
    @GET("stade")
    fun getStadeList(): Call<StadeList>
    @GET("stade")
    fun searchStade(@Query("name")searchText:String): Call<StadeList>
    @GET("stade/{stade_id}")
    fun getUser(@Path("stade_id") stade_id:String): Call<StadeList>
    @POST("stade")
    fun createUser(@Body params: Stade): Call<StadeResponse>
    @DELETE("stade/{stade_id}")
    fun deleteUser(@Path("stade_id") stade_id: String): Call<StadeList>
    @PATCH("stade/{stade_id}")
    fun updateUser(@Path("stade_id") stade_id: String, @Body params: Stade): Call<StadeList>
}