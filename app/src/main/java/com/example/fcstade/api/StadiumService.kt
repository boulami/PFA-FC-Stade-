package com.example.fcstade.api

import com.example.fcstade.models.*
import retrofit2.Call
import retrofit2.http.*

interface StadiumService {
    @GET("")
    @Headers("Content-Type: application/json")
    fun getStadiumList(): Call<StadiumList>

    @Headers("Content-Type: application/json")
    @POST("")
    fun createStadium(@Body params: Stadium): Call<StadiumResponse>

    @Headers("Content-Type: application/json")
    @DELETE("")
    fun deleteUser(@Path("name") name: String): Call<StadiumList>

}