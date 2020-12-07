package com.example.udacity_project_one.screens.listing

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.udacity_project_one.R
import com.example.udacity_project_one.databinding.ItemWidgetBinding
import com.example.udacity_project_one.databinding.ListingsFragmentBinding
import com.example.udacity_project_one.screens.details.Details_FragmentDirections.Companion.actionGlobalLoginFragment

class ListingsFragment : Fragment() {

    // Create private lateinit vars for the view model and binding
    private lateinit var viewModel: ListViewModel
    private lateinit var binding: ListingsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Use DataBindingUtil to inflate the view
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.listings_fragment,
            container,
            false
        )
        // Set listener for the floating action button. Navigates to the details fragment
        binding.fab.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                ListingsFragmentDirections.actionListingsFragmentToDetailsFragment()
            )
        )
        // Has a menu for logout. Navigates back to the login fragment
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Create activityViewModels for the list of widgets
        viewModel = activityViewModels<ListViewModel>().value
        // Observe itemList and inflate an item_widget for each widget currently in the list
        viewModel.itemList.observe(viewLifecycleOwner) {
            with(binding) {
                layoutContainerItem.removeAllViews() // Remove all item_widgets
                for (item in it) {
                    val itemBinding = DataBindingUtil.inflate<ItemWidgetBinding>(
                        layoutInflater,
                        R.layout.item_widget,
                        layoutContainerItem,
                        true
                    )
                    itemBinding.myItem = item
                }
            }
        }
    }

    // Create the menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.navdrawer_menu, menu)
    }

    // Navigate to login screen whenever logout is clicked
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_logout -> {
                findNavController().navigate(actionGlobalLoginFragment())
            }
        }
        return super.onOptionsItemSelected(item)
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