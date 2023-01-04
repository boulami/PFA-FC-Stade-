package com.example.fcstade.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fcstade.R
import com.example.fcstade.models.Stadium.ListStItem

class StadiumAdapter : RecyclerView.Adapter<StadiumAdapter.MyViewHolder>(){
   private var stadiumList: ArrayList<ListStItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StadiumAdapter.MyViewHolder {
        val inflater=LayoutInflater.from(parent.context).inflate(R.layout.stade_item,parent,false)

        return MyViewHolder(inflater)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<ListStItem>) {
        stadiumList = data as ArrayList<ListStItem>
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: StadiumAdapter.MyViewHolder, position: Int) {
        stadiumList[position].let {
            holder.adresse.text = it.address.toString()
            holder.name.text = it.name.toString()

        }
    }

    override fun getItemCount(): Int {
        return stadiumList.size
    }

    class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        val name:TextView=view.findViewById(R.id.name)
        val adresse:TextView=view.findViewById(R.id.adresse)
        fun bind(data: ListStItem){
            name.text=data.name
            adresse.text=data.address
        }

    }
}