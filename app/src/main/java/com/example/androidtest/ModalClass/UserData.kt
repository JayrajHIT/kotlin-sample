package com.example.androidtest.ModalClass

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*
import kotlin.collections.ArrayList

class UserData : Serializable {
    @SerializedName("info")
    @Expose
    var info: Info? = null

    @SerializedName("results") var results : ArrayList<Result>? = null


}