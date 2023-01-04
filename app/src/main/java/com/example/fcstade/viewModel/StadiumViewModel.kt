package com.example.fcstade.viewModel

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fcstade.api.RetroStadiumInstance
import com.example.fcstade.api.StadiumService
import com.example.fcstade.models.StadiumList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StadiumViewModel :ViewModel(){
    lateinit var stadiumListData: MutableLiveData<StadiumList>
    init {
        stadiumListData= MutableLiveData()

    }

    fun getStadiumListObservable():MutableLiveData<StadiumList>{
        return stadiumListData
    }
    fun getStadiumList(){
        val stadiumInstance=RetroStadiumInstance.getRetroStadiumInstance().create(StadiumService::class.java)
        val call=stadiumInstance.getStadiumList()
        call.enqueue(object:Callback<StadiumList>{
            override fun onResponse(call: Call<StadiumList>, response: Response<StadiumList>) {
                if (response.isSuccessful){
                    stadiumListData.postValue(response.body())
                    Log.d(ContentValues.TAG, response.body().toString())
                    Log.d(ContentValues.TAG, response.code().toString())
                }else{

                }
            }

            override fun onFailure(call: Call<StadiumList>, t: Throwable) {
                stadiumListData.postValue(null)
            }

        })
    }
}