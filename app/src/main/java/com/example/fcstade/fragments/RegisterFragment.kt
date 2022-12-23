package com.example.fcstade.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import com.example.fcstade.R
import com.example.fcstade.adapter.UserAdapter
import com.example.fcstade.databinding.FragmentPlayersBinding
import com.example.fcstade.databinding.FragmentRegisterBinding
import com.example.fcstade.models.UserResponse
import com.example.fcstade.viewModel.CreateUserViewModel
import com.example.fcstade.viewModel.UserViewModel

class RegisterFragment : Fragment(R.layout.fragment_register) {

    private lateinit var binding : FragmentRegisterBinding
    private lateinit var createUserViewModel: CreateUserViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentRegisterBinding.bind(view)
        initRecclerView(binding)
        createUserObservable()

    }

    private fun initRecclerView(binding: FragmentRegisterBinding) {
        createUserViewModel=ViewModelProvider(this).get(CreateUserViewModel::class.java)
    }


    private fun createUserObservable(){
        createUserViewModel.getCreateUserObservable().observe(viewLifecycleOwner,Observer<UserResponse?>{
            if (it==null){
                Toast.makeText(context,"failed",Toast.LENGTH_LONG)
            }
            else{
                Toast.makeText(context,"Success",Toast.LENGTH_LONG)
            }
        })
    }


}