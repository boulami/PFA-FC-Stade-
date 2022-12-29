package com.example.fcstade.fragments

import android.nfc.Tag
import android.os.Bundle
import android.util.Log
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
import com.example.fcstade.models.User
import com.example.fcstade.models.UserResponse
import com.example.fcstade.viewModel.CreateUserViewModel
import com.example.fcstade.viewModel.UserViewModel

class RegisterFragment : Fragment(R.layout.fragment_register) {

    private lateinit var binding : FragmentRegisterBinding
    private lateinit var createUserViewModel: CreateUserViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentRegisterBinding.bind(view)

       // val username = binding.username.text.toString()

        binding.register1.setOnClickListener {
            initRecylerView(binding)
            createUser()
        }
    }
    private fun createUser(){
        val user =User(user_id = 1, firstName = "hamza", lastName = "boulami", email = "hamza@gmail.Com", age = 19, password = "123", username = "hamza")
        createUserViewModel.createUser(user)
    }


    private fun initRecylerView(binding: FragmentRegisterBinding) {
        createUserViewModel=ViewModelProvider(this).get(CreateUserViewModel::class.java)
        createUserViewModel.getCreateUserObservable().observe(viewLifecycleOwner,Observer<UserResponse?>{
            if (it==null){
                Toast.makeText(context,"failed to create user",Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(context,"success",Toast.LENGTH_LONG).show()
            }
        })
    }




}