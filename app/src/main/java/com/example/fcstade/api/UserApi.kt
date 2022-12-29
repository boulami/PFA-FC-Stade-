package com.example.fcstade.api

import com.example.fcstade.models.User
import com.example.fcstade.models.UserList
import com.example.fcstade.models.UserResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface UserApi {
    @GET("auth/signup")
    fun getUserList():Call<UserList>
    @GET("auth/signup")
    fun searchUsers(@Query("first_name")searchText:String):Call<UserList>
    @GET("auth/signup")
    fun getUser(@Path("user_id") user_id:String):Call<UserList>
    @POST("auth/signup")
    fun createUser(@Body params: User):Call<UserResponse>
    @DELETE("auth/signup")
    fun deleteUser(@Path("user_id")user_id: String):Call<UserResponse>
    @PATCH("auth/signup")
    fun updateUser(@Path("user_id") user_id: String,@Body params: User):Call<UserResponse>

}