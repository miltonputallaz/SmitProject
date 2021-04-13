package com.sanicorporation.smitproject.network

sealed class NetworkStatus<out d: Any>  {
    data class Success<out d: Any>(val result: d): NetworkStatus<d>()
    data class Error<out d: Any>(val status: String, val code: String, val message: String): NetworkStatus<Nothing>()
    object Loading : NetworkStatus<Nothing>()
}