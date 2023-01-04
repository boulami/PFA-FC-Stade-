package com.example.fcstade.api

import com.example.fcstade.models.Stadium.ListSt
import com.example.fcstade.models.Stadium.ListStItem
import com.example.fcstade.models.Stadium.StadiumResponse
import retrofit2.Call
import retrofit2.http.*

interface StadiumService {
    @GET("/stadium/getAllStades")
    fun getStadiumList(): Call<ListSt>

    @Headers("Content-Type: application/json")
    @POST("/add")
    fun createStadium(@Body params: ListStItem): Call<StadiumResponse>

    @Headers("Content-Type: application/json")
    @DELETE("/{id}")
    fun deleteUser(@Path("name") name: String): Call<ListSt>

    @PATCH("/update/{id}")
    @Headers("Content-Type: application/json")
    fun updateStadium(@Path("name") name: String,@Body params: ListStItem):Call<StadiumResponse>

}