package com.example.fcstade.viewModel

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fcstade.api.RetroStadiumInstance
import com.example.fcstade.api.StadiumService
import com.example.fcstade.models.Stadium.ListSt
import com.example.fcstade.models.Stadium.ListStItem
import com.example.fcstade.models.Stadium.StadiumResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StadiumViewModel :ViewModel(){
    private val _stadiums = MutableLiveData<ListSt>()
    lateinit var createStadiumLiveData: MutableLiveData<StadiumResponse>
    lateinit var loadStadiumData: MutableLiveData<StadiumResponse>
    val stadiums: LiveData<ListSt> = _stadiums

    init {
        createStadiumLiveData= MutableLiveData()
        loadStadiumData= MutableLiveData()
    }

    fun getCreateStadiumObserver():MutableLiveData<StadiumResponse>{
        return createStadiumLiveData
    }

    fun getLoadStadiumObserver():MutableLiveData<StadiumResponse>{
        return loadStadiumData
    }


    fun createNewStadium(stadium:ListStItem){
        Log.d("TAG", stadium.toString())
        val stadiumService=RetroStadiumInstance.getRetroStadiumInstance().create(StadiumService::class.java)
        val call=stadiumService.createStadium(stadium)
        call.enqueue(object:Callback<StadiumResponse>{
            override fun onResponse(
                call: Call<StadiumResponse>,
                response: Response<StadiumResponse>
            ) {
                if(response.isSuccessful){
                    createStadiumLiveData.postValue(response.body())
                    Log.d(ContentValues.TAG, response.body().toString())
                    Log.d(ContentValues.TAG, response.code().toString())
                }
                else{
                    createStadiumLiveData.postValue(null)
                    Log.d(ContentValues.TAG, response.body().toString())
                    Log.d(ContentValues.TAG, response.code().toString())
                }
            }

            override fun onFailure(call: Call<StadiumResponse>, t: Throwable) {
                createStadiumLiveData.postValue(null)
            }

        })
    }

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
                    _stadiums.postValue(response.body())
                    Log.d(ContentValues.TAG, response.body().toString())
                    Log.d(ContentValues.TAG, response.code().toString())
                }
            }

            override fun onFailure(call: Call<ListSt>, t: Throwable) {

            }
        })
    }

    fun loadStadiumData(id:String){
        val stadiumInstance=RetroStadiumInstance.getRetroStadiumInstance().create(StadiumService::class.java)
        val call=stadiumInstance.getStadeById(id)

        call.enqueue(object:Callback<StadiumResponse>{
            override fun onResponse(
                call: Call<StadiumResponse>,
                response: Response<StadiumResponse>
            ) {
                if(response.isSuccessful){
                    loadStadiumData.postValue(response.body())
                    Log.d(ContentValues.TAG, response.body().toString())
                    Log.d(ContentValues.TAG, response.code().toString())
                }
                else{
                    loadStadiumData.postValue(null)
                    Log.d(ContentValues.TAG, response.body().toString())
                    Log.d(ContentValues.TAG, response.code().toString())
                }
            }

            override fun onFailure(call: Call<StadiumResponse>, t: Throwable) {
                loadStadiumData.postValue(null)
            }

        })

    }

    fun updateStadium(id:String,stadium:ListStItem){
        Log.d("TAG", stadium.toString())
        val stadiumInstance=RetroStadiumInstance.getRetroStadiumInstance().create(StadiumService::class.java)
        val call=stadiumInstance.updateStadium(id,stadium)

        call.enqueue(object : Callback<StadiumResponse>{
            override fun onResponse(
                call: Call<StadiumResponse>,
                response: Response<StadiumResponse>
            ) {
                if (response.isSuccessful){
                    createStadiumLiveData.postValue(response.body())
                    Log.d(ContentValues.TAG, response.body().toString())
                    Log.d(ContentValues.TAG, response.code().toString())
                }
                else{
                    createStadiumLiveData.postValue(null)
                    Log.d(ContentValues.TAG, response.body().toString())
                    Log.d(ContentValues.TAG, response.code().toString())

                }

            }

            override fun onFailure(call: Call<StadiumResponse>, t: Throwable) {
                createStadiumLiveData.postValue(null)
            }

        })

    }
}