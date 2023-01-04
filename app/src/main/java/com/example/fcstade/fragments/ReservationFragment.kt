package com.example.fcstade.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fcstade.R
import com.example.fcstade.adapter.UserAdapter
import com.example.fcstade.databinding.FragmentPlayersBinding
import com.example.fcstade.models.UserList

class ReservationFragment : Fragment(R.layout.fragment_players) {

    lateinit var userAdapter: UserAdapter
//    lateinit var userViewModel:UserViewModel
    private lateinit var binding :FragmentPlayersBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentPlayersBinding.bind(view)
    }
}

