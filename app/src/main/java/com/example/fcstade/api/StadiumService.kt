package com.example.fcstade.api

import com.example.fcstade.models.Stadium.ListSt
import com.example.fcstade.models.Stadium.ListStItem
import com.example.fcstade.models.Stadium.StadiumResponse
import retrofit2.Call
import retrofit2.http.*

interface StadiumService {
    @GET("/stadium/getAllStades")
    @Headers("Content-Type: application/json")
    fun getStadiumList(): Call<ListSt>

    @PATCH("/stadium/getStade/{id}")
    @Headers("Content-Type: application/json")
    fun getStadeById(@Path("id") id: String):Call<StadiumResponse>

    //    @Headers("Content-Type: application/json")
    @POST("/stadium/add")
    @Headers("Content-Type: application/json")
    fun createStadium(@Body params: ListStItem): Call<StadiumResponse>

    @Headers("Content-Type: application/json")
    @DELETE("/{id}")
    fun deleteUser(@Path("name") name: String): Call<ListSt>

    @PATCH("/stadium/update/{id}")
    @Headers("Content-Type: application/json")
    fun updateStadium(@Path("id") id: String,@Body params: ListStItem):Call<StadiumResponse>

}