package com.example.fcstade.models


data class UserList(val data: List<User>)
data class User(val user_id:Int?,val firstName:String?,val lastName:String?,val age:Int?,val username:String?,val password:String?,val email:String?)
data class UserResponse(val code:Int?,val meta:String?,val data:User?)
