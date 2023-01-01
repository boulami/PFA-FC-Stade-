package com.example.fcstade.api

import com.example.fcstade.models.User
import com.example.fcstade.models.UserResponse
import retrofit2.Call
import retrofit2.http.*

interface UserService {
    @Headers("Content-Type: application/json")
    @POST("auth/signup")
    fun createUser(@Body params: User):Call<UserResponse>
    @DELETE("auth/signup")
    fun deleteUser(@Path("user_id")user_id: String):Call<UserResponse>
    @PATCH("auth/signup")
    fun updateUser(@Path("user_id") user_id: String,@Body params: User):Call<UserResponse>

}