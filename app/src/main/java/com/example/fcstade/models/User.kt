package com.example.fcstade.models


data class UserList(val data: List<User>)
data class User(val user_id:Int?,val first_name:String?,val last_name:String?,val age:Int?,val username:String?)
data class UserResponse(val code:Int?,val meta:String?,val data:User?)
