package com.example.fcstade.fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.fcstade.R
import com.example.fcstade.databinding.FragmentConnexionBinding
import com.example.fcstade.models.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ConnexionFragment : Fragment(R.layout.fragment_connexion) {

    private lateinit var binding : FragmentConnexionBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_connexion, container, false)
        val connexionBtn: Button = view.findViewById(R.id.connexion)
        val registerBtn: Button =view.findViewById(R.id.register)
        connexionBtn.setOnClickListener {
            findNavController().navigate(R.id.action_connexionFragment_to_stadesFragment)
        }

        registerBtn.setOnClickListener {
            findNavController().navigate(R.id.action_connexionFragment_to_registerFragment)
        }
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentConnexionBinding.bind(view)

    }
}