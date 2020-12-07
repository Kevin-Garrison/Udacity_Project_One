package com.example.udacity_project_one.screens.listing

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemData(
    var name: String = "" ,
    var company: String = "",
    var size: String = "",
    var description: String = ""
) : Parcelable