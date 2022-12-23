package com.example.fcstade.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fcstade.api.RetroStadeInstance
import com.example.fcstade.api.RetroUserInstance
import com.example.fcstade.api.StadeApi
import com.example.fcstade.api.UserApi
import com.example.fcstade.models.StadeList
import com.example.fcstade.models.UserList
import retrofit2.Call
import retrofit2.Response

class StadeViewModel:ViewModel() {
    lateinit var recyclerStadeList: MutableLiveData<StadeList>


    init {
        recyclerStadeList= MutableLiveData()
    }

    fun getStadeListObservable(): MutableLiveData<StadeList> {
        return recyclerStadeList
    }

    fun getStadeList(){
        val retroStadeInstance= RetroStadeInstance.getRetroStadeInstance().create(StadeApi::class.java)
        val call=retroStadeInstance.getStadeList()

        call.enqueue(object :retrofit2.Callback<StadeList>{
            override fun onResponse(call: Call<StadeList>, response: Response<StadeList>) {
                if(response.isSuccessful){
                    recyclerStadeList.postValue(response.body())

                }else{
                    recyclerStadeList.postValue(null)
                }
            }

            override fun onFailure(call: Call<StadeList>, t: Throwable) {
                recyclerStadeList.postValue(null)
            }
        })
    }
}