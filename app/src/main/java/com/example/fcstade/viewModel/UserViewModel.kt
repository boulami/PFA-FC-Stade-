package com.example.fcstade.viewModel

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fcstade.api.RetroUserInstance
import com.example.fcstade.api.UserService
import com.example.fcstade.models.UserList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel :ViewModel(){
    lateinit var userListData : MutableLiveData<UserList>

    init {
        userListData= MutableLiveData()

    }

    fun getUserListObservable():MutableLiveData<UserList>{
        return userListData
    }

    fun getUserList(){
        val retroUserInstance=RetroUserInstance.getRetroUserInstance().create(UserService::class.java)
        val call=retroUserInstance.getUserList()
        call.enqueue(object :Callback<UserList>{
            override fun onResponse(call: Call<UserList>, response: Response<UserList>) {
                if(response.isSuccessful){
                    userListData.postValue(response.body())
                    Log.d(ContentValues.TAG, response.body().toString())
                    Log.d(ContentValues.TAG, response.code().toString())
                }else{
                    userListData.postValue(response.body())
                    Log.d(TAG, "onResponse: erreur list ")
                    Log.d(ContentValues.TAG, response.body().toString())
                    Log.d(ContentValues.TAG, response.code().toString())

                }
            }

            override fun onFailure(call: Call<UserList>, t: Throwable) {
                userListData.postValue(null)
            }

        })
    }

    fun searchUser(searchText:String){
        val retroUserInstance=RetroUserInstance.getRetroUserInstance().create(UserService::class.java)
        val call=retroUserInstance.searchUsers(searchText)
        call.enqueue(object :Callback<UserList>{
            override fun onResponse(call: Call<UserList>, response: Response<UserList>) {
                if(response.isSuccessful){
                    userListData.postValue(response.body())
                    Log.d(ContentValues.TAG, response.body().toString())
                    Log.d(ContentValues.TAG, response.code().toString())
                }else{
                    userListData.postValue(response.body())
                    Log.d(TAG, "onResponse: erreur list ")
                    Log.d(ContentValues.TAG, response.body().toString())
                    Log.d(ContentValues.TAG, response.code().toString())

                }
            }

            override fun onFailure(call: Call<UserList>, t: Throwable) {
                userListData.postValue(null)
            }

        })

    }
}