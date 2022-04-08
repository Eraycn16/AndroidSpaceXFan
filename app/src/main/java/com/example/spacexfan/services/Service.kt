package com.example.spacexfan.services

import com.example.spacexfan.models.Company
import com.example.spacexfan.models.Rockets
import com.example.spacexfan.models.Upcoming
import retrofit2.Call
import retrofit2.http.GET

interface Service {

    @GET("v4/rockets")
    fun getRockets(): Call<Rockets>

    @GET("v5/launches/upcoming")
    fun getUpcoming() : Call<Upcoming>

    @GET("v4/company")
    fun getCompanyInfo(): Call<Company>
}