package com.sanicorporation.smitproject.network

import com.sanicorporation.smitproject.domain.ResponseClass
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface SpecieService {
    @GET("species")
    fun getSpecies(@Query("page") user: Int): Call<ResponseClass>
}