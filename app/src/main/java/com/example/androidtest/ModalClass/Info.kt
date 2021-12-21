package com.example.androidtest.ModalClass

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Info : Serializable {
    var seed: String? = null

    @SerializedName("results")
    @Expose
    var results: Int? = null

    @SerializedName("page")
    @Expose
    var page: Int? = null

    @SerializedName("version")
    @Expose
    var version: String? = null
}