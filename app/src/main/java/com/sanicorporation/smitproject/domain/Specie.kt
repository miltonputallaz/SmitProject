package com.sanicorporation.smitproject.domain

import com.google.gson.annotations.SerializedName

data class Specie(
    @SerializedName("name")
    val  name: String,
    @SerializedName("classification")
    val classification: String,
    @SerializedName("designation")
    val designation: String
)
