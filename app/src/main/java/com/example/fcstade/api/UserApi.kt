package com.example.fcstade.api

import com.example.fcstade.models.User
import com.example.fcstade.models.UserList
import com.example.fcstade.models.UserResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface UserApi {
    @GET("users")
    fun getUserList():Call<UserList>
    @GET("users")
    fun searchUsers(@Query("first_name")searchText:String):Call<UserList>
    @GET("users/{user_id}")
    fun getUser(@Path("user_id") user_id:String):Call<UserList>
    @POST("users")
    fun createUser(@Body params: User):Call<UserResponse>
    @DELETE("users/{user_id}")
    fun deleteUser(@Path("user_id")user_id: String):Call<UserResponse>
    @PATCH("users/{user_id}")
    fun updateUser(@Path("user_id") user_id: String,@Body params: User):Call<UserResponse>

}