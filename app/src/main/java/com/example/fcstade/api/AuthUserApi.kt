package com.example.fcstade.api

import com.example.fcstade.models.AuthUser
import com.example.fcstade.models.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthUserApi {

    @POST("auth/signin")
    fun login(@Body authUser: AuthUser):Call<UserResponse>
}