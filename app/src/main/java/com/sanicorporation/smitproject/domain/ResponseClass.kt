package com.sanicorporation.smitproject.domain

import com.google.gson.annotations.SerializedName


data class ResponseClass(
        @SerializedName("results")
        val results: List<Specie>
)