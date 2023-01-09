package com.example.fcstade.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fcstade.R
import com.example.fcstade.models.Stadium.ListStItem

class   StadiumAdapter(private val listener: OnItemClickListener) : RecyclerView.Adapter<StadiumAdapter.MyViewHolder>(){
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
            holder.adresse.text = it.address
            holder.name.text = it.name
        }

    }

    override fun getItemCount(): Int {
        return stadiumList.size
    }

    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val name:TextView=itemView.findViewById(R.id.name)
        val adresse:TextView=itemView.findViewById(R.id.adresse)
        fun bind(data: ListStItem){
            name.text=data.name
            adresse.text=data.address
        }
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p: View?) {
            val position=adapterPosition
            if (position!=RecyclerView.NO_POSITION){
                listener.onItemclick(position)
            }
        }

    }

    interface OnItemClickListener{
        fun onItemclick(position: Int )
    }



}