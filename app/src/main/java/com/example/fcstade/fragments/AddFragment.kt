package com.example.fcstade.fragments

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.fcstade.R
import com.example.fcstade.databinding.FragmentAddBinding
import com.example.fcstade.databinding.FragmentListeStadeBinding
import com.example.fcstade.databinding.FragmentRegisterBinding
import com.example.fcstade.models.Stadium.ListStItem
import com.example.fcstade.models.Stadium.StadiumResponse
import com.example.fcstade.viewModel.StadiumViewModel
import java.util.*

class AddFragment : Fragment(R.layout.fragment_add) {

    private lateinit var binding : FragmentAddBinding
    lateinit var stadeViewModel:StadiumViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentAddBinding.bind(view)
        binding.addStadium.setOnClickListener {
            initViewModel(binding)
            createStadium()
        }
    }
    private fun createStadium(){
        val stadium=ListStItem(binding.name.text.toString(),binding.address.text.toString())
        stadeViewModel.createNewStadium(stadium)
    }
    private fun initViewModel(binding: FragmentAddBinding){
        stadeViewModel=ViewModelProvider(this).get(StadiumViewModel::class.java)
        stadeViewModel.getCreateStadiumObserver().observe(viewLifecycleOwner,Observer<StadiumResponse?>{
            if(it==null){
                Toast.makeText(context,"Failed to create stadium",Toast.LENGTH_LONG)

            }else{
                Toast.makeText(context,"Stadium added successfully",Toast.LENGTH_LONG)
            }

        })
    }
}