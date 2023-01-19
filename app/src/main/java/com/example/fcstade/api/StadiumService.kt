package com.example.fcstade.api

import com.example.fcstade.models.Stadium.ListSt
import com.example.fcstade.models.Stadium.ListStItem
import com.example.fcstade.models.Stadium.StadiumResponse
import com.example.fcstade.models.Stadium.response.stadiumResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface StadiumService {
    @GET("/stadium/getAllStades")
    @Headers("Content-Type: application/json")
    fun getStadiumList(): Call<ListSt>

    @GET("/stadium/getStade/{id}")
    fun getStadiumById(@Path("id") id: String): Call<stadiumResponse>

    //    @Headers("Content-Type: application/json")
    @POST("/stadium/add")
    @Headers("Content-Type: application/json")
    fun createStadium(@Body params: ListStItem): Call<StadiumResponse>

    @Headers("Content-Type: application/json")
    @DELETE("/stadium/{id}")
    fun deleteUser(@Path("id") name: String): Call<ListSt>

    @PATCH("/stadium/update/{id}")
    @Headers("Content-Type: application/json")
    fun updateStadium(@Path("id") id: String,@Body params: ListStItem):Call<StadiumResponse>

}