package com.example.spacexfan.utils

import android.util.Log
import com.example.spacexfan.services.Service
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private val url = "https://api.spacexdata.com/"

    private var retrofit: Retrofit? = null

    fun getClient(): Retrofit{

        if(retrofit == null){

            retrofit = Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build()

        }
        return retrofit!!
    }
}