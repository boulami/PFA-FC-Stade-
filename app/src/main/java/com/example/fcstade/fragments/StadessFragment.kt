package com.example.fcstade.fragments

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fcstade.R
import com.example.fcstade.adapter.StadiumAdapter
import com.example.fcstade.databinding.FragmentStadessBinding
import com.example.fcstade.models.Stadium.ListStItem
import com.example.fcstade.viewModel.StadiumViewModel

class stadessFragment : Fragment(R.layout.fragment_stadess),StadiumAdapter.OnItemClickListener  {
    private lateinit var binding : FragmentStadessBinding
    lateinit var stadessAdapter: StadiumAdapter
    lateinit var stadessviewModel: StadiumViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentStadessBinding.bind(view)
        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView(){
        stadessAdapter = StadiumAdapter(this)

        binding.stadess.apply {
            layoutManager= LinearLayoutManager(context)
            val decoration = DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL)
            addItemDecoration(decoration)
            adapter=stadessAdapter
        }
    }
    fun initViewModel(){
        stadessviewModel= ViewModelProvider(this).get(StadiumViewModel::class.java)
        stadessviewModel.getStadiumList()
        stadessviewModel.stadiums.observe(viewLifecycleOwner, Observer {
            Log.d("initViewModel", it.toString())
                stadessAdapter.setData(it)
        })
    }

    override fun onItemclick(position: Int) {
        findNavController().navigate(R.id.updateStadeFragment)
       // val clickedItem=
    }

}