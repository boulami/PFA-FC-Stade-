package com.example.fcstade.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fcstade.R
import com.example.fcstade.databinding.FragmentSplashBinding


class SplashFragment : Fragment(R.layout.fragment_splash) {
    private var _binding: FragmentSplashBinding?=null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_splash, container, false)
        Handler(Looper.myLooper()!!).postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_welcomeFragment)
        }, 3000)

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}