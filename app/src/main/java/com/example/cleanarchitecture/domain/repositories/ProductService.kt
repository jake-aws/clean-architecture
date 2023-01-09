package com.example.cleanarchitecture.domain.repositories

import com.example.cleanarchitecture.domain.entities.Product
import retrofit2.Response

interface ProductService {
    suspend fun getProductById(productID:Int):Response<Product>
}