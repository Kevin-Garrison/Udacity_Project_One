package com.example.udacity_project_one.screens.instructions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.udacity_project_one.R
import com.example.udacity_project_one.databinding.InstructionsFragmentBinding

class InstructionsFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val binding: InstructionsFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.instructions_fragment, container, false)
        // Set listener for buttonListings. Navigates to the list fragment
        binding.buttonListings.setOnClickListener { view: View ->
            view.findNavController().navigate(InstructionsFragmentDirections.actionInstructionsFragmentToListingsFragment())
        }
        return binding.root
    }
}

/*
Create a new Instruction destination that includes:
      * A new layout
      * At least 2 textviews with appropriate information
      * A navigation button with actions to navigate to the shoe list screen
 */