package com.example.cleanarchitecture.domain.repositories

import androidx.lifecycle.LiveData
import com.example.cleanarchitecture.data.local.ProductDB
import com.example.cleanarchitecture.data.local.ProductEntity

interface ProductRepository {

    suspend fun insertProductItem(productEntity: ProductEntity)

    suspend fun deleteProductItem(productEntity: ProductEntity)

    fun getAllProducts():LiveData<List<ProductEntity>>

    fun getProductByID(productID:Int):LiveData<ProductEntity>
}