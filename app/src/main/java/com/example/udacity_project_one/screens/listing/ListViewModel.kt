package com.example.udacity_project_one.screens.listing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.udacity_project_one.screens.listing.ItemData

class ListViewModel : ViewModel()  {

    // A mutable list of test widgets
    private val _itemList = MutableLiveData<List<ItemData>>()
    val itemList: LiveData<List<ItemData>>
        get() = _itemList

    // Add a new widget to the list
    fun addItem(item: ItemData) {
        val list = _itemList.value?.toMutableList() ?: mutableListOf()
        list.add(item)
        _itemList.value = list
    }

    // Add test widgets to the list
    init {
        val defaultList = mutableListOf<ItemData>()
        defaultList.add(ItemData("Widget Whacker","XL","Widget Whackers Inc.","A Whacker with which you can whack widgets"))
        defaultList.add(ItemData("Wonder Widget","L","Widget Minds","A widget that can predict the future"))
        defaultList.add(ItemData("Big Az Widget","XXL","OMG Widgets","A widget so big it has its own gravitational pull that comes with a description so big that I have to see how the text will appear within the view."))
        defaultList.add(ItemData("Widget Watcher","M","Widget Whackers Inc.","Watch widgets with this widget watcher"))
        defaultList.add(ItemData("Fidget Widget","S","Bob's Widgets","A widget that needs to cut down on the caffeine"))
        defaultList.add(ItemData("Big Ole Widget","XXXL","Widget Minds","A big widget with a big appetite"))
        _itemList.value = defaultList
    }
}