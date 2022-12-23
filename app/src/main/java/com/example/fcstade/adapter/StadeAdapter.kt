package com.example.fcstade.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fcstade.R
import com.example.fcstade.models.Stade
import com.example.fcstade.models.StadeList

class StadeAdapter:RecyclerView.Adapter<StadeAdapter.MyViewHolder>() {

    var stadeList=mutableListOf<Stade>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StadeAdapter.MyViewHolder {
        val inflater= LayoutInflater.from(parent.context).inflate(R.layout.stade_item,parent,false)
        return MyViewHolder(inflater)
    }


    override fun onBindViewHolder(holder: StadeAdapter.MyViewHolder, position: Int) {
        holder.bind(stadeList[position])
    }

    override fun getItemCount(): Int {
        return stadeList.size
    }


    class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        var name: TextView = view.findViewById(R.id.name_stade)
        var status: TextView = view.findViewById(R.id.stade_status)
        var adresse: TextView = view.findViewById(R.id.position)

        fun bind (data: Stade){
            name.text=data.name
            status.text=data.status
            adresse.text=data.adresse
        }

    }
}