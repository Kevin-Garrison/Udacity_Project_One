package com.example.udacity_project_one.screens.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.udacity_project_one.screens.listing.ItemData

class DetailsViewModel : ViewModel()  {

    // The new widget to be created
    private val _newItem = MutableLiveData<ItemData>()
    val newItem: LiveData<ItemData>
        get() = _newItem

    // Encapsulated data that validates data entered in the details view
    private val _validName = MutableLiveData<Boolean>()
    val validName: LiveData<Boolean>
        get() = _validName

    private val _validSize = MutableLiveData<Boolean>()
    val validSize: LiveData<Boolean>
        get() = _validSize

    private val _validCompany = MutableLiveData<Boolean>()
    val validCompany: LiveData<Boolean>
        get() = _validCompany

    /*private val _itemPosition = MutableLiveData<Int>()
    val itemPosition: LiveData<Int>
        get() = _itemPosition*/

    private val _validDescription = MutableLiveData<Boolean>()
    val validDescription: LiveData<Boolean>
        get() = _validDescription

    // Validate all values
    fun validateAll() {
        _validName.value = true
        _validCompany.value = true
        _validSize.value = true
        _validDescription.value = true
    }

    // Validate data and save it to _newItem
    fun saveData(
        itemData: ItemData) {

        val (name, size, company, description) = itemData

        val nameValid = !name.isBlank()
        _validName.value = nameValid

        val sizeValid = !size.isBlank()
        _validSize.value = sizeValid

        val companyValid = !company.isBlank()
        _validCompany.value = companyValid

        val descriptionValid = !description.isBlank()
        _validDescription.value = descriptionValid

        val dataIsReady = nameValid && sizeValid && companyValid && descriptionValid

        if (dataIsReady) {
            _newItem.value = itemData
        }
    }
}