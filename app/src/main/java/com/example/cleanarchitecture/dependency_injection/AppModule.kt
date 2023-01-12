package com.example.cleanarchitecture.dependency_injection

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cleanarchitecture.data.local.ProductDB
import com.example.cleanarchitecture.data.local.ProductDB_Impl
import com.example.cleanarchitecture.data.remote.ProductAPI
import com.example.cleanarchitecture.data.repositories.ProductServiceImpl
import com.example.cleanarchitecture.domain.repositories.ProductService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideProductDB(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, ProductDB::class.java, "Product_Database").build()

    @Singleton
    @Provides
    fun provideDao(productDB: ProductDB) = productDB.productDao()

    @Singleton
    @Provides
    fun provideAPI(): ProductAPI {
        return Retrofit.Builder().baseUrl("https://dummyjson.com/")
            .addConverterFactory(MoshiConverterFactory.create()).build()
            .create(ProductAPI::class.java)
    }

    @Singleton
    @Provides
    fun provideRepository(api: ProductAPI):ProductService{
        return ProductServiceImpl(api)
    }
}