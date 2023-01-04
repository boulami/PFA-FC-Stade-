package com.example.fcstade.api

import com.example.fcstade.models.users.User
import com.example.fcstade.models.users.UserList
import com.example.fcstade.models.users.UserResponse
import retrofit2.Call
import retrofit2.http.*

interface UserService {

    @Headers("Content-Type: application/json")
    @POST("/add")
    fun createUser(@Body params: User):Call<UserResponse>

    @Headers("Content-Type: application/json")
    @DELETE("auth/signup")
    fun deleteUser(@Path("user_id")user_id: String):Call<UserResponse>


    @GET("auth/signup")
    @Headers("Content-Type: application/json")
    fun searchUsers(@Query("username") searchText: String):Call<UserList>

}