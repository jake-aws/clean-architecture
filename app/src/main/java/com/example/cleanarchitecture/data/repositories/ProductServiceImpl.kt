package com.example.cleanarchitecture.data.repositories

import com.example.cleanarchitecture.data.remote.ProductAPI
import com.example.cleanarchitecture.domain.entities.Product
import com.example.cleanarchitecture.domain.repositories.ProductService
import retrofit2.Response

class ProductServiceImpl(private val productAPI: ProductAPI):ProductService {

    override suspend fun getProductByID(productID: Int): Response<Product> {
       return productAPI.getProductByID(productID)
    }
}