package com.example.fcstade.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.fcstade.R
import com.example.fcstade.databinding.FragmentListeReservJoueurBinding
import com.example.fcstade.databinding.FragmentStadesBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class ListeReservJoueur : Fragment(R.layout.fragment_liste_reserv_joueur) {
    private lateinit var binding : FragmentListeReservJoueurBinding


    companion object{
        lateinit var navController: NavController
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        binding = FragmentListeReservJoueurBinding.bind(view)
        // initViewModel()
        val navHost=childFragmentManager.findFragmentById(R.id.navigation1) as NavHostFragment
        navController =navHost.findNavController()
        view.findViewById<BottomNavigationView>(R.id.navigation_bottom1).setupWithNavController(
            navController
        )
    }
}