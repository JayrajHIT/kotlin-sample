package com.example.sammple.Interface

import com.example.androidtest.ModalClass.UserData

import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET(BASE_URL)
    fun GetUserData(): Call<UserData?>?

    companion object {
        const val BASE_URL = "https://randomuser.me/api/?results=40"
    }
}