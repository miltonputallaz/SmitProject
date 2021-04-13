package com.sanicorporation.smitproject.di.module

import android.content.Context
import com.sanicorporation.smitproject.network.SpecieService
import com.sanicorporation.smitproject.repository.remote.RemoteSpeciesRepository
import com.sanicorporation.smitproject.repository.remote.RemoteSpeciesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class SpeciesModule {

    @Provides
    @Singleton
    fun provide(retrofit: Retrofit): SpecieService =
            retrofit.create(SpecieService::class.java)


}
