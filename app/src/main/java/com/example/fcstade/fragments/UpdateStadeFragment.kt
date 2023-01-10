package com.example.fcstade.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.fcstade.R
import com.example.fcstade.databinding.FragmentAddBinding
import com.example.fcstade.databinding.FragmentUpdateStadeBinding
import com.example.fcstade.models.Stadium.ListStItem
import com.example.fcstade.models.Stadium.StadiumResponse
import com.example.fcstade.viewModel.StadiumViewModel

class UpdateStadeFragment : Fragment(R.layout.fragment_update_stade) {

    private lateinit var binding : FragmentUpdateStadeBinding
    lateinit var stadeViewModel: StadiumViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentUpdateStadeBinding.bind(view)

        binding.update.setOnClickListener {
            update()
        }
        initViewModel(binding)
    }


    private fun initViewModel(binding: FragmentUpdateStadeBinding){
        stadeViewModel= ViewModelProvider(this).get(StadiumViewModel::class.java)
        stadeViewModel.getLoadStadiumObserver().observe(viewLifecycleOwner, Observer<StadiumResponse?>{
            if(it!=null){
                binding.name2.setText(it.data?.name)
                binding.adresse2.setText(it.data.address)

            }
        })
        stadeViewModel.loadStadiumData(binding.name2.text.toString())
    }

    private fun update(){
        val stadium=ListStItem(binding.name2.text.toString(),binding.adresse2.text.toString())
        stadeViewModel.updateStadium(binding.name2.text.toString(),stadium)
    }
}