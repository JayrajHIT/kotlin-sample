package com.example.androidtest.ModalClass

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Picture : Serializable {
    @SerializedName("large")
    @Expose
    var large: String? = null

    @SerializedName("medium")
    @Expose
    var medium: String? = null

    @SerializedName("thumbnail")
    @Expose
    var thumbnail: String? = null
}