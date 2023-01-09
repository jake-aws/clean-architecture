package com.example.cleanarchitecture.dependency_injection

import com.example.cleanarchitecture.data.remote.ProductAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAPI():ProductAPI{
        return Retrofit.Builder().baseUrl("https://dummyjson.com/")
            .addConverterFactory(MoshiConverterFactory.create()).build().create(ProductAPI::class.java)
    }
}