package com.example.fcstade.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.fcstade.R


class ConnexionFragment : Fragment(R.layout.fragment_connexion) {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_connexion, container, false)
        val connexionBtn: Button = view.findViewById(R.id.connexion)
        connexionBtn.setOnClickListener {
            findNavController().navigate(R.id.action_connexionFragment_to_stadesFragment)
        }
        return view
    }

}