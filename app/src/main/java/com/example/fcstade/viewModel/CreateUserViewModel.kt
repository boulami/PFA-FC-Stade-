package com.example.fcstade.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fcstade.api.RetroUserInstance
import com.example.fcstade.api.UserApi
import com.example.fcstade.models.User
import com.example.fcstade.models.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreateUserViewModel:ViewModel() {

    lateinit var createUserLiveData: MutableLiveData<UserResponse>

    init {
        createUserLiveData= MutableLiveData()
    }

    fun getCreateUserObservable() : MutableLiveData<UserResponse> {
        return createUserLiveData
    }

    fun createUser(user: User){
        val retroUserInstance=RetroUserInstance.getRetroUserInstance().create(UserApi::class.java)
        val call=retroUserInstance.createUser(user)
        call.enqueue(object :Callback<UserResponse?>{

            override fun onResponse(call: Call<UserResponse?>, response: Response<UserResponse?>) {
                if(response.isSuccessful){
                    createUserLiveData.postValue(response.body())
                }else{
                    createUserLiveData.postValue(null)
                }
            }

            override fun onFailure(call: Call<UserResponse?>, t: Throwable) {
                createUserLiveData.postValue(null)
            }
        })
    }
}