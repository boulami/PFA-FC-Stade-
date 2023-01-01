package com.example.fcstade.fragments

import android.os.Bundle
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

class PlayersFragment : Fragment(R.layout.fragment_players) {

 /*   lateinit var userAdapter: UserAdapter
    lateinit var userViewModel: UserViewModel
    private lateinit var binding :FragmentPlayersBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentPlayersBinding.bind(view)
        initRecyclerView(binding)
        initViewModel()
    }

    private fun initRecyclerView(binding: FragmentPlayersBinding) {
        binding.listePlayers.apply {
            layoutManager = LinearLayoutManager(context)
            val decoration=DividerItemDecoration(context,DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            userAdapter= UserAdapter()
            adapter=userAdapter
        }
    }
    fun initViewModel(){
        userViewModel=ViewModelProvider(this).get(UserViewModel::class.java)
        userViewModel.getUserListObservable().observe(viewLifecycleOwner, Observer <UserList?>{
            if (it==null){
                Toast.makeText(context,"no result",Toast.LENGTH_LONG).show()
            }else{
                userAdapter.userList=it.data.toMutableList()
                userAdapter.notifyDataSetChanged()
            }
        })
    }*/
}

