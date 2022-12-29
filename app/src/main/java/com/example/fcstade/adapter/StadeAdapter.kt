package com.example.fcstade.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fcstade.R
import com.example.fcstade.models.Stade
import com.example.fcstade.models.StadeList

class StadeAdapter:RecyclerView.Adapter<StadeAdapter.MyViewHolder>() {
    private var date= arrayOf("17/12/2022","17/08/2023","14/05/2023","14/02/2022")
    private var location = arrayOf("mabrooka","echarraf","fadl","bab lakhmiss")
  //  private var price = arrayOf()
    private val images= intArrayOf(R.drawable.stadium,R.drawable.stadium,R.drawable.stadium,R.drawable.stadium,R.drawable.stadium)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StadeAdapter.MyViewHolder {
        val v=LayoutInflater.from(parent.context).inflate(R.layout.stade_item,parent,false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: StadeAdapter.MyViewHolder, position: Int) {
        holder.itemDate.text=date[position]
        holder.itemLocation.text=location[position]
        holder.itemImage.setImageResource(images[position])

    }

    override fun getItemCount(): Int {
        return date.size
    }

    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var itemImage:ImageView
        var itemDate:TextView
        var itemLocation:TextView
        var itemJoueur:TextView
        var itemPrix:TextView

        init {
            itemImage=itemView.findViewById(R.id.image_stade)
            itemDate=itemView.findViewById(R.id.date)
            itemLocation=itemView.findViewById(R.id.location)
            itemJoueur=itemView.findViewById(R.id.numberOfPlayer)
            itemPrix=itemView.findViewById(R.id.price)
        }


    }

}