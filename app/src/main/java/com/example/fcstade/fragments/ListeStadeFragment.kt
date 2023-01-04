package com.example.fcstade.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fcstade.R
import com.example.fcstade.adapter.StadiumAdapter
import com.example.fcstade.databinding.FragmentListeStadeBinding
import com.example.fcstade.databinding.FragmentRegisterBinding
import com.example.fcstade.models.StadiumList
import com.example.fcstade.viewModel.StadiumViewModel


class ListeStadeFragment : Fragment(R.layout.fragment_liste_stade) {

    private lateinit var binding : FragmentListeStadeBinding
    lateinit var stadiumAdapter:StadiumAdapter
    lateinit var viewModel: StadiumViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentListeStadeBinding.bind(view)
        initRecycler()
        initViewModel()
    }

    private fun initRecycler(){
        binding.listeStades.apply {
            layoutManager=LinearLayoutManager(context)
            val decoration =DividerItemDecoration(context,DividerItemDecoration.HORIZONTAL)
            addItemDecoration(decoration)
            stadiumAdapter=StadiumAdapter()
            adapter=stadiumAdapter

        }
    }

    fun initViewModel(){
        viewModel=ViewModelProvider(this).get(StadiumViewModel::class.java)
        viewModel.getStadiumListObservable().observe(this,Observer<StadiumList>{
            if (it==null){
                Toast.makeText(context,"no stadium",Toast.LENGTH_LONG)
            }else{
                stadiumAdapter.stadiumList=it.data.toMutableList()
                stadiumAdapter.notifyDataSetChanged()
            }
        })
    }
}