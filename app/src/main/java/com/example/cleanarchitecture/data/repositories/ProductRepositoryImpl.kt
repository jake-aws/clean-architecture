package com.example.cleanarchitecture.data.repositories

import androidx.lifecycle.LiveData
import com.example.cleanarchitecture.data.local.ProductDB
import com.example.cleanarchitecture.data.local.ProductDao
import com.example.cleanarchitecture.data.local.ProductEntity
import com.example.cleanarchitecture.data.remote.ProductAPI
import com.example.cleanarchitecture.domain.repositories.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productDao: ProductDao,
    private val productAPI: ProductAPI,
) : ProductRepository {
    override suspend fun insertProductItem(productEntity: ProductEntity) {
        productDao.insertProduct(productEntity)
    }

    override suspend fun deleteProductItem(productEntity: ProductEntity) {
       productDao.deleteProduct(productEntity)
    }

    override fun getAllProducts(): LiveData<List<ProductEntity>> {
        return productDao.getAllProducts()
    }

    override fun getProductByID(productID: Int): LiveData<ProductEntity> {
        return productDao.getProduct(productID)
    }
}