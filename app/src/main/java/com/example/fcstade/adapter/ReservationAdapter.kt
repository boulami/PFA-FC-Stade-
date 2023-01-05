package com.example.fcstade.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fcstade.R
import com.example.fcstade.models.Stadium.ListStItem
import com.example.fcstade.models.reservation.Reservation
import com.example.fcstade.models.reservation.ReservationList

class ReservationAdapter:RecyclerView.Adapter<ReservationAdapter.MyViewHolder>() {
    private var reservationList: ArrayList<Reservation> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater=LayoutInflater.from(parent.context).inflate(R.layout.reservation_item,parent,false)
        return ReservationAdapter.MyViewHolder(inflater)
    }



    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<Reservation>) {
        reservationList = data as ArrayList<Reservation>
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: ReservationAdapter.MyViewHolder, position: Int) {
        reservationList[position].let {
            holder.startDate.text=it.startDate.toString()
            holder.endDate.text=it.endDate.toString()

        }
    }


    override fun getItemCount(): Int {
        return reservationList.size
    }


    class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
    //    val stadium:TextView=view.findViewById(R.id.name)
    //    val gestId:TextView=view.findViewById(R.id.adresse)
        val startDate:TextView=view.findViewById(R.id.startDate)
        val endDate:TextView=view.findViewById(R.id.endDate)
    //    val guestName:TextView=view.findViewById(R.id.)
    //    val guesEmail:TextView=view.findViewById(R.id.)

        fun bind(data: Reservation){
            startDate.text=data.startDate
            endDate.text=data.endDate
        }



    }


}