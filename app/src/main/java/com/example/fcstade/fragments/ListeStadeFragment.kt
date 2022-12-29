package com.example.fcstade.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fcstade.R
import com.example.fcstade.adapter.StadeAdapter
import com.example.fcstade.databinding.FragmentListeStadeBinding
import com.example.fcstade.databinding.FragmentPlayersBinding


class ListeStadeFragment : Fragment(R.layout.fragment_liste_stade) {

    private var layoutManager:RecyclerView.LayoutManager?=null
    private var adapter:RecyclerView.Adapter<StadeAdapter.MyViewHolder>?=null
    private lateinit var binding : FragmentListeStadeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layoutManager=LinearLayoutManager(context)
    }
}