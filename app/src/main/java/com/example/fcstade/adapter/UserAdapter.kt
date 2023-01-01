package com.example.fcstade.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fcstade.R
import com.example.fcstade.models.User


class UserAdapter:RecyclerView.Adapter<UserAdapter.MyViewHolder>() {

    var userList= mutableListOf<User>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.MyViewHolder {
        val inflater=LayoutInflater.from(parent.context).inflate(R.layout.player_item,parent,false)
        return MyViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: UserAdapter.MyViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        var first_name: TextView = view.findViewById(R.id.first_name)
        var last_name: TextView = view.findViewById(R.id.last_name)
        var username:TextView=view.findViewById(R.id.username)
        var password: TextView=view.findViewById(R.id.pass)

        fun bind (data:User){
            first_name.text=data.firstName
            last_name.text=data.lastName
            username.text=data.username
            password.text=data.password
        }

    }

}