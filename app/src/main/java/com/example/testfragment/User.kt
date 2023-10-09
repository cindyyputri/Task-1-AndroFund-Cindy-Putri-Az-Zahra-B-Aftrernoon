package com.example.testfragment

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val name:String,
    val address:String,
    val nohp:String
):Parcelable
