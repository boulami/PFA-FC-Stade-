package com.example.fcstade.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.fcstade.R
import com.example.fcstade.databinding.FragmentRegisterBinding
import com.example.fcstade.models.User
import com.example.fcstade.models.UserResponse
import com.example.fcstade.viewModel.CreateUserViewModel

class RegisterFragment : Fragment(R.layout.fragment_register) {

    private lateinit var binding : FragmentRegisterBinding
    private lateinit var createUserViewModel: CreateUserViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentRegisterBinding.bind(view)


        binding.register1.setOnClickListener {
            initRecylerView(binding)
            createUser()
        }
    }
    private fun createUser(){
        val user=User(id = "1", firstName = "hamza", lastName = "boulami", age = "24", email = "hamza@gmail.Com", password = "123", username = "hamza1")
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