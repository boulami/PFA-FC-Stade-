package com.example.fcstade.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fcstade.R
import com.example.fcstade.databinding.FragmentListeStadeBinding


class ListeStadeFragment : Fragment(R.layout.fragment_liste_stade) {

    private var layoutManager:RecyclerView.LayoutManager?=null
    private lateinit var binding : FragmentListeStadeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layoutManager=LinearLayoutManager(context)
    }
}