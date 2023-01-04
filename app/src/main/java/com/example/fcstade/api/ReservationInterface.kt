package com.example.fcstade.api

import com.example.fcstade.models.Stadium.ListSt
import com.example.fcstade.models.Stadium.ListStItem
import com.example.fcstade.models.Stadium.StadiumResponse
import com.example.fcstade.models.reservation.Reservation
import com.example.fcstade.models.reservation.ReservationList
import com.example.fcstade.models.reservation.ReservationResponse
import retrofit2.Call
import retrofit2.http.*

interface ReservationInterface {
    @GET("/reservation/getAllReservations")
    fun getAllReservations(): Call<ReservationList>

 //   @Headers("Content-Type: application/json")
    @POST("/reservation/add")
    fun createReservation(@Body params: Reservation): Call<ReservationResponse>

 //   @Headers("Content-Type: application/json")
    @DELETE("/reservation/{id}")
    fun deleteReservation(@Path("name") name: String): Call<ListSt>

    @PATCH("/reservation/update/{id}")
 //   @Headers("Content-Type: application/json")
    fun updateStadium(@Path("name") name: String, @Body params: ListStItem):Call<StadiumResponse>
}