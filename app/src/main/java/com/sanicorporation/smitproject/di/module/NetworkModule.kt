package com.sanicorporation.smitproject.di.module

import android.content.Context
import com.google.gson.GsonBuilder
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
class NetworkModule {

    companion object{
        val BASE_URL: String = "https://swapi.dev/api/"
    }

    @Provides
    @Singleton
    fun provideBaseRetrofitEndpoint(@ApplicationContext context: Context): Retrofit =
        Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
}