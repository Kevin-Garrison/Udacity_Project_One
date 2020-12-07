package com.example.udacity_project_one.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.udacity_project_one.R
import com.example.udacity_project_one.databinding.LoginFragmentBinding

class LoginFragment: Fragment() {

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: LoginFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.login_fragment,
            container,
            false
        )
        // Get the view model provider
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Observe the email text to see if it is valid
        viewModel.hasValidEmail.observe(viewLifecycleOwner, Observer { valid ->
            binding.labelEmail.error = if (valid) {
                null
            } else {
                getString(R.string.error_email_empty)
            }
        })

        // Observe the password text to see if it is valid
        viewModel.hasValidPassword.observe(viewLifecycleOwner, Observer { valid ->
            binding.labelPassword.error = if (valid) {
                null
            } else {
                getString(R.string.error_password_empty)
            }
        })

        // Observe the hasInfo to trigger the navigation to the welcome screen
        viewModel.hasInfo.observe(viewLifecycleOwner, Observer { allowed ->
            if (allowed) {
                nextNav()
                viewModel.resetValues(false)
            }
        })

        //Listen for text changes and button clicks
        with(binding) {
            editEmail.addTextChangedListener {
                viewModel.testEmailValid(binding.editEmail.text?.toString() ?: "")
            }
            editPassword.addTextChangedListener {
                viewModel.testPasswordValid(binding.editPassword.text?.toString() ?: "")
            }
            loginAccount.setOnClickListener {
                viewModel.checkPass()
            }
            createAccount.setOnClickListener {
                viewModel.checkPass()
            }
        }
    }

    /**
     * Called when the ready for next navigation
     */
    private fun nextNav() {
        findNavController().navigate(LoginFragmentDirections
            .actionLoginFragmentToWelcomeFragment())
    }
}

/*
Create a new Login destination.
      * Include email and password labels
      * Include email and password fields
      * Create buttons for creating a new login and logging in with an existing account
      * Clicking either button should navigate to the Welcome Screen.
 */