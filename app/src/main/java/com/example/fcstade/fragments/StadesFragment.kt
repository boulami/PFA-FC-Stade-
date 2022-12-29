package com.example.fcstade.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.fcstade.R
import com.example.fcstade.adapter.StadeAdapter
import com.example.fcstade.databinding.FragmentStadesBinding
import com.example.fcstade.models.StadeList
import com.google.android.material.bottomnavigation.BottomNavigationView


class StadesFragment : Fragment(R.layout.fragment_stades) {
    lateinit var stadeAdapter: StadeAdapter
  //  lateinit var stadeViewModel: StadeViewModel
    private lateinit var binding : FragmentStadesBinding

    companion object{
        lateinit var navController: NavController
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        binding = FragmentStadesBinding.bind(view)
       // initViewModel()
        val navHost=childFragmentManager.findFragmentById(R.id.navigation) as NavHostFragment
        navController =navHost.findNavController()
        view.findViewById<BottomNavigationView>(R.id.navigation_bottom).setupWithNavController(
            navController
        )
    }

  /*  private fun initViewModel() {
        stadeViewModel=ViewModelProvider(this).get(StadeViewModel::class.java)
        stadeViewModel.getStadeListObservable().observe(viewLifecycleOwner, Observer<StadeList>{
            if(it==null){
                Toast.makeText(context,"no result",Toast.LENGTH_LONG)
            } else{
        //        stadeAdapter.stadeList=it.data.toMutableList()
                stadeAdapter.notifyDataSetChanged()
            }
        })
    }*/
}