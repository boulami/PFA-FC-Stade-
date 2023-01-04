package com.example.fcstade.models.reservation

data class Reservation(
    val stadiumId: String,
    val gestId: String,
    val startDate: String,
    val endDate:String,
    val guestName:String,
    val guesEmail:String
)
