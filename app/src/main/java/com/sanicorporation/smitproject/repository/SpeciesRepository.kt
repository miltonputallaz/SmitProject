package com.sanicorporation.smitproject.repository

import androidx.lifecycle.LiveData
import com.sanicorporation.smitproject.domain.Specie
import com.sanicorporation.smitproject.network.NetworkStatus
import com.sanicorporation.smitproject.repository.remote.RemoteSpeciesRepository
import com.sanicorporation.smitproject.repository.remote.RemoteSpeciesRepositoryImpl
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SpeciesRepository @Inject constructor(val remoteSpeciesRepository: RemoteSpeciesRepositoryImpl) {

    fun getSpecies(page: Int): LiveData<NetworkStatus<List<Specie>>>{
        return remoteSpeciesRepository.getSpecies(page)
    }
}