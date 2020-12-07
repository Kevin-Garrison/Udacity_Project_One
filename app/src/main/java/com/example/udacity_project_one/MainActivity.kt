package com.example.udacity_project_one

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
//import com.example.udacity_project_one.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController)

        navController.addOnDestinationChangedListener { controller, _, _ ->
            val shouldShowUpButton = controller.previousBackStackEntry != null
            supportActionBar?.setDisplayHomeAsUpEnabled(shouldShowUpButton)

        /*val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val navController = this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController)*/

        // prevent nav gesture if not on start destination
        /*navController.addOnDestinationChangedListener { nc: NavController, nd: NavDestination, args: Bundle? ->
            if (nd.id == nc.graph.startDestination) {
                //drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
            } else {
                //drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
            }
        }*/

        /*appBarConfiguration = AppBarConfiguration(navController.graph)
        NavigationUI.setupWithNavController(binding.navView, navController)*/
    }

    //override fun onSupportNavigateUp(): Boolean {
        //val navController = this.findNavController(R.id.myNavHostFragment)
        //return navController.navigateUp()
        //return NavigationUI.navigateUp(drawerLayout, navController)
        //return NavigationUI.navigateUp(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}

/*
In |MainActivity|, setup the nav controller with the toolbar and an |AppBarConfiguration|

In MainActivity, add a Logout menu to return to the login screen
 */