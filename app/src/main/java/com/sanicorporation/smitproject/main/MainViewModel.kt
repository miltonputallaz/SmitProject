package com.sanicorporation.smitproject.main

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.sanicorporation.smitproject.domain.Specie
import com.sanicorporation.smitproject.network.NetworkStatus
import com.sanicorporation.smitproject.repository.SpeciesRepository

@BindingAdapter("android:speciesData")
fun setNewSpecies(view: RecyclerView, species: List<Specie>) {
    view.adapter?.let {
        val speciesAdapter = it as SpeciesRecyclerAdapter
        speciesAdapter.setNewSpecies(species)
    } ?: run {
        view.layoutManager = LinearLayoutManager(view.context)
        view.adapter = SpeciesRecyclerAdapter(species)
    }
}

@BindingAdapter("android:onRefreshListener")
fun setListenerForSwipe(swipe: SwipeRefreshLayout, listener: SwipeRefreshLayout.OnRefreshListener) {
    swipe.setOnRefreshListener(listener)
}

@BindingAdapter("android:refreshing")
fun setListenerForSwipe(swipe: SwipeRefreshLayout, refreshing: Boolean) {
    swipe.isRefreshing = refreshing
}

@BindingAdapter("android:scrollListener")
fun setListenerForScroll(recycler: RecyclerView, listener: RecyclerView.OnScrollListener) {
    recycler.addOnScrollListener(listener)
}


class MainViewModel @ViewModelInject constructor(
    repository: SpeciesRepository
): ViewModel() {

    val species : MediatorLiveData<List<Specie>> = MediatorLiveData<List<Specie>>().apply {
        value = listOf()
    }

    val refreshListener: SwipeRefreshLayout.OnRefreshListener = SwipeRefreshLayout.OnRefreshListener {
        species.addSource(repository.getSpecies(1), {
            setData(it)
        })
        refreshing.postValue(true)
    }


    val refreshing: MutableLiveData<Boolean> = MutableLiveData(false)

    init {
        species.addSource(repository.getSpecies(1), {
            setData(it)
        })
    }

    private fun setData(response: NetworkStatus<List<Specie>>){
        when (response) {
            is NetworkStatus.Loading -> {

            }
            is NetworkStatus.Success -> {
                refreshing.postValue(false)
                species.postValue(response.result)
            }
        }
    }

}