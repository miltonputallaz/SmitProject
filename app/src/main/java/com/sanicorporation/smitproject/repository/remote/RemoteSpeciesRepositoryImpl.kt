package com.sanicorporation.smitproject.repository.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sanicorporation.smitproject.domain.ResponseClass
import com.sanicorporation.smitproject.domain.Specie
import com.sanicorporation.smitproject.network.NetworkStatus
import com.sanicorporation.smitproject.network.SpecieService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteSpeciesRepositoryImpl @Inject constructor(val remoteService: SpecieService): RemoteSpeciesRepository {

    override fun getSpecies(page: Int): LiveData<NetworkStatus<List<Specie>>> {
        val speciesLiveData: MutableLiveData<NetworkStatus<List<Specie>>> = MutableLiveData(NetworkStatus.Loading)

        remoteService.getSpecies(page).enqueue(object : Callback<ResponseClass> {
            override fun onResponse(call: Call<ResponseClass>, response: Response<ResponseClass>) {
                response.body()?.let {
                    speciesLiveData.postValue(NetworkStatus.Success(it.results))
                }
            }

            override fun onFailure(call: Call<ResponseClass>, t: Throwable) {
                speciesLiveData.postValue(NetworkStatus.Error<List<Specie>>("Bad Request","400",t.localizedMessage ?: "Error"))
            }

        })

        return speciesLiveData

    }

}