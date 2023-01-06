package com.example.fcstade.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fcstade.R
import com.example.fcstade.adapter.ReservationAdapter
import com.example.fcstade.databinding.FragmentPlayersBinding
import com.example.fcstade.databinding.FragmentReservationssBinding
import com.example.fcstade.viewModel.ReservationViewModel


class ReservationssFragment : Fragment(R.layout.fragment_reservationss) {
    private lateinit var binding : FragmentReservationssBinding
    lateinit var reserAdapter: ReservationAdapter
    lateinit var reserViewModel: ReservationViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentReservationssBinding.bind(view)
        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView(){
        binding.reservations.apply {
            layoutManager= LinearLayoutManager(context)
            val decoration = DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL)
            addItemDecoration(decoration)
            reserAdapter= ReservationAdapter()
            adapter=reserAdapter
        }
    }

    fun initViewModel(){
        reserViewModel= ViewModelProvider(this).get(ReservationViewModel::class.java)
        reserViewModel.getAllReservations()
        reserViewModel.reservation.observe(viewLifecycleOwner, Observer {
            Log.d("initViewModel", it.toString())
            reserAdapter.setData(it)
        })
    }



}