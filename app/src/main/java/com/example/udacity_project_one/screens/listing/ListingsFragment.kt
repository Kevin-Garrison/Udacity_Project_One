package com.example.udacity_project_one.screens.listing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.udacity_project_one.R
import com.example.udacity_project_one.databinding.ListingsFragmentBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class ListingsFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val binding: ListingsFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.listings_fragment, container, false)

        /*binding.CreateNewLoginButton.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginToWelcome())
        }*/

        binding.fab.setOnClickListener { view: View ->
            view.findNavController().navigate(ListingsFragmentDirections.actionListingsFragmentToDetailsFragment())
        }

        return binding.root
    }
}

/*
Create a class that extends |ViewModel|
      * Use a |LiveData| field that returns the list of shoes

Create a new Shoe List destination that includes:
      * A new layout
      * A |ScrollView|
      * A |LinearLayout| inside the |ScrollView| for Shoe Items
      * A |FloatingActionButton| with an action to navigate to the shoe detail screen

Make sure you can't go back to onboarding screens In the Shoe List screen:
      * use an Activity level |ViewModel| to hold a list of Shoes (use by |activityViewModels|)
      * Observe the shoes variable from the |ViewModel|
      * Add a new layout item into the scrollview for each shoe.
 */