package com.example.udacity_project_one.screens.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.udacity_project_one.R
import com.example.udacity_project_one.databinding.WelcomeFragmentBinding

class WelcomeFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val binding: WelcomeFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.welcome_fragment, container, false)
        // Set listener for the continue button
        binding.buttonContinue.setOnClickListener { view: View ->
            view.findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment())
        }
        return binding.root
    }
}

/*
Create a new Welcome screen destination that includes:
      * A new layout
      * At least 2 textviews and use any text you would like
      * A navigation button with actions to navigate to the instructions screen
 */