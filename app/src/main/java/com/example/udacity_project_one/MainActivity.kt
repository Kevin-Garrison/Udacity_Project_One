package com.example.udacity_project_one

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {

    // Get the nav controller
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Assign the nav controller
        navController = findNavController(R.id.myNavHostFragment)
        // Set up with an Action Bar - AppBarConfiguration
        NavigationUI.setupActionBarWithNavController(this, navController)
        // Configure the nav controller to not navigate back to login screen
        navController.addOnDestinationChangedListener { controller, _, _ ->
            val showButton = controller.previousBackStackEntry != null
            supportActionBar?.setDisplayHomeAsUpEnabled(showButton)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}

/*
In |MainActivity|, setup the nav controller with the toolbar and an |AppBarConfiguration|

In MainActivity, add a Logout menu to return to the login screen
 */