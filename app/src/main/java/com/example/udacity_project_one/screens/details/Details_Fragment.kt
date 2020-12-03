package com.example.udacity_project_one.screens.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.udacity_project_one.R
import com.example.udacity_project_one.databinding.DetailsFragmentBinding

class Details_Fragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val binding: DetailsFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.details_fragment, container, false)

        /*binding.CreateNewLoginButton.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginToWelcome())
        }*/

        binding.buttonCancel.setOnClickListener { view: View ->
            view.findNavController().navigate(Details_FragmentDirections.actionDetailsFragmentToListingsFragment())
        }

        binding.buttonAdd.setOnClickListener { view: View ->
            view.findNavController().navigate(Details_FragmentDirections.actionDetailsFragmentToListingsFragment())
        }

        return binding.root
    }
}

/*
Create a new Shoe Detail destination that includes:
      * A new layout
      * A |TextView| label and |EditView| for the:
         Shoe Name,
         Company,
         Shoe Size and
         Description
      * A Cancel button with an action to navigate back to the shoe list screen
      * A Save button with an action to navigate back to the shoe list screen and
        add a new Shoe to the Shoe View Model
 */