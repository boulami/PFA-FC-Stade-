package com.example.fcstade.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fcstade.R
import com.example.fcstade.models.Stadium

class StadiumAdapter : RecyclerView.Adapter<StadiumAdapter.MyViewHolder>(){
    var stadiumList= mutableListOf<Stadium>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StadiumAdapter.MyViewHolder {
        val inflater=LayoutInflater.from(parent.context).inflate(R.layout.stade_item,parent,false)

        return MyViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: StadiumAdapter.MyViewHolder, position: Int) {
        holder.bind(stadiumList[position])
    }

    override fun getItemCount(): Int {
        return stadiumList.size
    }

    class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        val name:TextView=view.findViewById(R.id.name)
        val adresse:TextView=view.findViewById(R.id.adresse)
        fun bind(data: Stadium){
            name.text=data.name
            adresse.text=data.adresse
        }

    }
}