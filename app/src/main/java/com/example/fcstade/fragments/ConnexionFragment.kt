package com.example.fcstade.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.fcstade.R
import com.example.fcstade.databinding.FragmentConnexionBinding
import com.example.fcstade.databinding.FragmentRegisterBinding
import com.example.fcstade.models.AuthUser


class ConnexionFragment : Fragment(R.layout.fragment_connexion) {

    private lateinit var binding : FragmentConnexionBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentConnexionBinding.bind(view)
        initAction()

    }
    fun initAction(){
        binding.connexion.setOnClickListener {
           login()
        }
    }
    fun login(){
        val request=AuthUser()
        request.username=binding.username1.text.toString().trim()
        request.password=binding.password.text.toString().trim()
    }
/*    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_connexion, container, false)
        val connexionBtn: Button = view.findViewById(R.id.connexion)
        val registerBtn:Button=view.findViewById(R.id.register)
        connexionBtn.setOnClickListener {
            findNavController().navigate(R.id.action_connexionFragment_to_stadesFragment)
        }

        registerBtn.setOnClickListener {
            findNavController().navigate(R.id.action_connexionFragment_to_registerFragment)
        }
        return view
    }*/



}