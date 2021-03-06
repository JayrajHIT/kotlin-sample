package com.example.sammple.ApiCall

import com.example.sammple.Interface.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient private constructor() {
    val myApi: Api

    companion object {
        @kotlin.jvm.JvmStatic
        @get:Synchronized
        var instance: RetrofitClient? = null
            get() {
                if (field == null) {
                    field = RetrofitClient()
                }
                return field
            }
            private set
    }

    init {
        val retrofit = Retrofit.Builder().baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        myApi = retrofit.create(Api::class.java)
    }
}


