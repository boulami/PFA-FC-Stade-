package com.example.fcstade.viewModel

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fcstade.api.RetroStadiumInstance
import com.example.fcstade.api.StadiumService
import com.example.fcstade.models.res.ListSt
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StadiumViewModel :ViewModel(){
    private val _stadiums = MutableLiveData<ListSt>()
    val stadiums: LiveData<ListSt> = _stadiums

    fun getStadiumList(){
        val stadiumInstance=RetroStadiumInstance.getRetroStadiumInstance().create(StadiumService::class.java)
        val call=stadiumInstance.getStadiumList()
        call.enqueue(object:Callback<ListSt>{
            override fun onResponse(call: Call<ListSt>, response: Response<ListSt>) {
                if (response.isSuccessful){
                    _stadiums.postValue(response.body())
                    Log.d(ContentValues.TAG, response.body().toString())
                    Log.d(ContentValues.TAG, response.code().toString())
                }else{

                }
            }

            override fun onFailure(call: Call<ListSt>, t: Throwable) {
            }

        })
    }
}