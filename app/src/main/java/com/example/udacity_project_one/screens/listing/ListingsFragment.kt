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

    private lateinit var viewModel: ListViewModel
    private lateinit var binding: ListingsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.listings_fragment,
            container,
            false
        )
        binding.fab.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                ListingsFragmentDirections.actionListingsFragmentToDetailsFragment()
            )
        )
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = activityViewModels<ListViewModel>().value

        viewModel.itemList.observe(viewLifecycleOwner) {
            with(binding) {
                layoutContainerItem.removeAllViews()
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.navdrawer_menu, menu)
    }

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