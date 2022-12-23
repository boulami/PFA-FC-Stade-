package com.example.fcstade.models



data class StadeList(val data: List<Stade>)
data class Stade(val stade_id:Int?,val name:String?,val adresse:String?,val status:String?)
data class StadeResponse(val code:Int?,val meta:String?,val data:Stade?)
