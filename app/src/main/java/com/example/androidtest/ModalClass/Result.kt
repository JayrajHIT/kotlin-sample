package com.example.androidtest.ModalClass

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Result : Serializable {
    @SerializedName("gender")
    @Expose
    var gender: String? = null

    @SerializedName("email")
    @Expose
    var email: String? = null

    @SerializedName("phone")
    @Expose
    var phone: String? = null

    @SerializedName("cell")
    @Expose
    var cell: String? = null

    @SerializedName("nat")
    @Expose
    var nat: String? = null

    @SerializedName("name")
    @Expose
    var name: Name? = null

    @SerializedName("picture")
    @Expose
    var picture: Picture? = null

    @SerializedName("dob")
    @Expose
    var dob: Dob? = null

    @SerializedName("login")
    @Expose
    var login: Login? = null
}