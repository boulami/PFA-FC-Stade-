package com.example.fcstade.viewModel

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fcstade.api.ReservationInterface
import com.example.fcstade.api.RetroReservationInstance
import com.example.fcstade.api.RetroStadiumInstance
import com.example.fcstade.api.StadiumService
import com.example.fcstade.models.Stadium.ListSt
import com.example.fcstade.models.reservation.ReservationList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class ReservationViewModel  : ViewModel(){
    private val reservations = MutableLiveData<ReservationList>()
    val reservation: LiveData<ReservationList> = reservations

    fun getAllReservations(){
        val stadiumInstance=RetroStadiumInstance.getRetroStadiumInstance().create(ReservationInterface::class.java)
        val call=stadiumInstance.getAllReservations()
        call.enqueue(object:Callback<ReservationList>{
            override fun onResponse(
                call: Call<ReservationList>,
                response: Response<ReservationList>
            ) {
                if (response.isSuccessful){
                    reservations.postValue(response.body())
                    Log.d(ContentValues.TAG, response.body().toString())
                    Log.d(ContentValues.TAG, response.code().toString())
                }else{
                    reservations.postValue(response.body())
                    Log.d(ContentValues.TAG, response.body().toString())
                    Log.d(ContentValues.TAG, response.code().toString())
                }
            }

            override fun onFailure(call: Call<ReservationList>, t: Throwable) {

            }

        })
    }
}