package com.example.udacity_project_one.screens.details

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.udacity_project_one.R
import com.example.udacity_project_one.databinding.DetailsFragmentBinding
import com.example.udacity_project_one.screens.listing.ItemData
import com.example.udacity_project_one.screens.listing.ListViewModel

class Details_Fragment: Fragment() {

    // Declare private lateinit vars for binding, view models, and nav controler
    private lateinit var binding: DetailsFragmentBinding
    private lateinit var listViewModel: ListViewModel
    private lateinit var detailsViewModel: DetailsViewModel
    private lateinit var navController: NavController

    // Textwatcher object with overrides to monitor input
    private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        } // Do nothing

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            detailsViewModel.validateAll()
        }

        override fun afterTextChanged(s: Editable?) {
        } // Do nothing
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Use binding to inflate the view
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.details_fragment,
            container,
            false
        )
        navController = findNavController() // Get the navController

        // Get a view model for this fragment
        detailsViewModel = ViewModelProvider(this)[DetailsViewModel::class.java]

        // Observe newItem and add it, navigate back to the list
        detailsViewModel.newItem.observe(viewLifecycleOwner) {
            listViewModel.addItem(it)
            navController.navigateUp()
        }

        with(binding) {
            // reset errors when typing
            editName.addTextChangedListener(textWatcher)
            editSize.addTextChangedListener(textWatcher)
            editCompany.addTextChangedListener(textWatcher)
            editDescription.addTextChangedListener(textWatcher)

            // Observe validName and notify if invalid
            detailsViewModel.validName.observe(viewLifecycleOwner) {
                textName.error = if (!it) {
                    getString(R.string.error_name_empty)
                } else {
                    null
                }
            }
            // Observe validSize and notify if invalid
            detailsViewModel.validSize.observe(viewLifecycleOwner) {
                textSize.error = if (!it) {
                    getString(R.string.error_size_empty)
                } else {
                    null
                }
            }
            // Observe validCompany and notify if invalid
            detailsViewModel.validCompany.observe(viewLifecycleOwner) {
                textCompany.error = if (!it) {
                    getString(R.string.error_company_empty)
                } else {
                    null
                }
            }
            // Observe validDescription and notify if invalid
            detailsViewModel.validDescription.observe(viewLifecycleOwner) {
                textDescription.error = if (!it) {
                    getString(R.string.error_description_empty)
                } else {
                    null
                }
            }

        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Create activityViewModels for the list of widgets
        listViewModel = activityViewModels<ListViewModel>().value
        //Bind it to DetailsFragmentBinding
        binding.viewModel = detailsViewModel
        // Create the item the data will be saved to
        binding.item = ItemData("","","","")
        // Set listener for the cancel button and have it navigate back to the list
        binding.buttonCancel.setOnClickListener {
            navController.navigateUp()
        }
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