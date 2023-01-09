package com.example.fcstade.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fcstade.R
import com.example.fcstade.adapter.StadiumAdapter
import com.example.fcstade.databinding.FragmentListeStadeBinding
import com.example.fcstade.models.Stadium.ListStItem
import com.example.fcstade.viewModel.StadiumViewModel



class ListeStadeFragment : Fragment(R.layout.fragment_liste_stade),StadiumAdapter.OnItemClickListener {

    private lateinit var binding : FragmentListeStadeBinding
    lateinit var stadiumAdapter:StadiumAdapter
    private lateinit var viewModel: StadiumViewModel
    val stadiumList: ArrayList<ListStItem> = ArrayList()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentListeStadeBinding.bind(view)
        initRecycler()
        initViewModel()
        buildDisplayData()
    }

    private fun initRecycler(){
        binding.listeStades.apply {
            layoutManager=LinearLayoutManager(context)
            val decoration =DividerItemDecoration(context,DividerItemDecoration.HORIZONTAL)
            addItemDecoration(decoration)
            stadiumAdapter=StadiumAdapter(this@ListeStadeFragment)
            adapter=stadiumAdapter

        }
    }

    fun initViewModel(){
        viewModel=ViewModelProvider(this).get(StadiumViewModel::class.java)
        viewModel.getStadiumList()
        viewModel.stadiums.observe(viewLifecycleOwner, Observer {
           Log.d("initViewModel", it.toString())
           stadiumAdapter.setData(it)
       })
    }

    private fun buildDisplayData(){

    }

    override fun onItemclick(position: Int) {
        Toast.makeText(context,"item $position clicked", Toast.LENGTH_SHORT).show()
    }
}