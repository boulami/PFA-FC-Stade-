package com.example.fcstade.fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.fcstade.R
import com.example.fcstade.Utils.IDPOSITION
import com.example.fcstade.databinding.FragmentAddBinding
import com.example.fcstade.databinding.FragmentUpdateStadeBinding
import com.example.fcstade.models.Stadium.ListStItem
import com.example.fcstade.models.Stadium.StadiumResponse
import com.example.fcstade.viewModel.StadiumViewModel
import java.lang.Exception

class UpdateStadeFragment : Fragment(R.layout.fragment_update_stade) {

    private lateinit var binding : FragmentUpdateStadeBinding
    lateinit var stadeViewModel: StadiumViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentUpdateStadeBinding.bind(view)

     /*   binding.update.setOnClickListener {
            update()
        }*/
        initViewModel(binding)
    }


    private fun initViewModel(binding: FragmentUpdateStadeBinding){


        stadeViewModel= ViewModelProvider(this).get(StadiumViewModel::class.java)
        stadeViewModel.getStadeById(IDPOSITION)
        stadeViewModel.getLoadStadiumObserver().observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "itititit: " + it.toString())
            try {
                Log.d(TAG, "itititit: " + it.toString())
                binding.identifiant.setText(it.id)
                binding.name2.setText(it.name)
                binding.adresse2.setText(it.address)
            }catch(e: Exception){
            }
        })

    }

  /*  private fun update(){
        val stadium=ListStItem(binding.identifiant.text.toString(),binding.name2.text.toString(),binding.adresse2.text.toString())
        stadeViewModel.updateStadium(binding.identifiant.text.toString(),stadium)
    }*/
}