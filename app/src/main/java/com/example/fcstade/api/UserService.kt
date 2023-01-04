package com.example.fcstade.api

import com.example.fcstade.models.User
import com.example.fcstade.models.UserList
import com.example.fcstade.models.UserResponse
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.http.*

interface UserService {
    @GET("")
    @Headers("Content-Type: application/json")
    fun getUserList():Call<UserList>

    @Headers("Content-Type: application/json")
    @POST("auth/signup")
    fun createUser(@Body params: User):Call<UserResponse>

    @Headers("Content-Type: application/json")
    @DELETE("auth/signup")
    fun deleteUser(@Path("user_id")user_id: String):Call<UserResponse>


    @GET("auth/signup")
    @Headers("Content-Type: application/json")
    fun searchUsers(@Query("username") searchText: String):Call<UserList>

}