package com.sanicorporation.smitproject.repository.remote

import android.net.Network
import androidx.lifecycle.LiveData
import com.sanicorporation.smitproject.domain.Specie
import com.sanicorporation.smitproject.network.NetworkStatus

interface RemoteSpeciesRepository {
    fun getSpecies(page: Int): LiveData<NetworkStatus<List<Specie>>>
}