package com.example.udacity_project_one.screens.login

import android.text.Editable
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _hasValidEmail= MutableLiveData<Boolean>()
    val hasValidEmail: LiveData<Boolean>
        get() = _hasValidEmail

    private val _hasValidPassword= MutableLiveData<Boolean>()
    val hasValidPassword: LiveData<Boolean>
        get() = _hasValidPassword

    private val _hasInfo = MutableLiveData<Boolean>()
    val hasInfo: LiveData<Boolean>
        get() = _hasInfo

    /*private val _loginEmailText = MutableLiveData<String>()
    val loginEmailText: LiveData<String>
        get() = _loginEmailText

    private val _loginPasswordText = MutableLiveData<String>()
    val loginPasswordText: LiveData<String>
        get() = _loginPasswordText
    */

    fun testEmailValid(email: String) {
        _hasValidEmail.value = !email.isBlank()
        //_loginEmailText.value = email.toString()
        //Log.i("LoginViewModel", "email value set to $_loginEmailText.value")
    }

    fun testPasswordValid(password: String) {
        _hasValidPassword.value = !password.isBlank()
        //_loginPasswordText.value = password.toString()
        //Log.i("LoginViewModel", "email value set to $_loginPasswordText")
    }

    fun checkPass() {
        _hasInfo.value = validate()
    }

    fun resetValues(bTorF: Boolean) {
        _hasInfo.value = bTorF
        _hasValidEmail.value = bTorF
        _hasValidPassword.value = bTorF
        //_loginEmailText.value = ""
       // _loginPasswordText.value = ""
    }

    private fun validate(): Boolean {
        return true
    }
}