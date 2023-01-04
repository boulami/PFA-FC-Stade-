package com.example.fcstade.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fcstade.R
import com.example.fcstade.adapter.ReservationAdapter
import com.example.fcstade.adapter.StadiumAdapter
import com.example.fcstade.adapter.UserAdapter
import com.example.fcstade.databinding.FragmentPlayersBinding
import com.example.fcstade.viewModel.ReservationViewModel
import com.example.fcstade.viewModel.StadiumViewModel

class ReservationFragment : Fragment(R.layout.fragment_players) {

    private lateinit var binding :FragmentPlayersBinding
    lateinit var reservationAdapter: ReservationAdapter
    lateinit var reservationviewModel: ReservationViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentPlayersBinding.bind(view)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.listePlayers.apply {
            layoutManager=LinearLayoutManager(context)
            val decoration =DividerItemDecoration(context,DividerItemDecoration.HORIZONTAL)
            addItemDecoration(decoration)
            reservationAdapter= ReservationAdapter()
            adapter=reservationAdapter

        }
    }

    fun initViewModel(){
        reservationviewModel=ViewModelProvider(this).get(ReservationViewModel::class.java)
        reservationviewModel.getAllReservation()
        reservationviewModel.reservation.observe(viewLifecycleOwner, Observer {
            Log.d("initViewModel", it.toString())
            reservationAdapter.setData(it)
        })
    }
}

