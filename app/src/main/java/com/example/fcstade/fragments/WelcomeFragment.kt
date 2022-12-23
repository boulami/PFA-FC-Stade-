package com.example.fcstade.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.fcstade.R


class WelcomeFragment : Fragment(R.layout.fragment_welcome) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_welcome, container, false)
        val startBtn:Button=view.findViewById(R.id.start)
        startBtn.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_connexionFragment)
        }
        return view
    }
}