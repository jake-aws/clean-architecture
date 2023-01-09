package com.example.cleanarchitecture.data.remote

import com.example.cleanarchitecture.data.repositories.dto.ProductDTO
import com.example.cleanarchitecture.domain.entities.Product
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductAPI {
    @GET("products/{product_ID}")
    suspend fun getProductByID(@Path("product_ID") productID: Int): Response<Product>
}