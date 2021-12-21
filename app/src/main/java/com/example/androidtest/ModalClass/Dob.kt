package com.example.androidtest.ModalClass

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Dob : Serializable {
    @SerializedName("age")
    @Expose
    var age = 0
}