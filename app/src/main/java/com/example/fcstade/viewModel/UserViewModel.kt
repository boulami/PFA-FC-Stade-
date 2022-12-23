package com.example.fcstade.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fcstade.api.RetroUserInstance
import com.example.fcstade.api.UserApi
import com.example.fcstade.models.UserList
import retrofit2.Call
import retrofit2.Response

class UserViewModel : ViewModel(){
    lateinit var recyclerListData: MutableLiveData<UserList>


    init {
        recyclerListData= MutableLiveData()
    }

    fun getUserListObservable():MutableLiveData<UserList>{
        return recyclerListData
    }

    fun getUserList(){
        val retrouserInstance=RetroUserInstance.getRetroUserInstance().create(UserApi::class.java)
        val call=retrouserInstance.getUserList()

        call.enqueue(object :retrofit2.Callback<UserList>{
            override fun onResponse(call: Call<UserList>,response: Response<UserList>) {
                if(response.isSuccessful){
                    recyclerListData.postValue(response.body())
                }
                else{
                    recyclerListData.postValue(null)
                }

            }

            override fun onFailure(call: Call<UserList>, t: Throwable) {
                recyclerListData.postValue(null)
            }
        })
    }
}
