package com.example.cleanarchitecture.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cleanarchitecture.data.local.ProductEntity
import com.example.cleanarchitecture.domain.repositories.ProductRepository

class ProductRepositoryFakeImpl:ProductRepository {

    private val productItems = mutableListOf<ProductEntity>()
    private val observableProductItems = MutableLiveData<List<ProductEntity>>(productItems)
    private var shouldReturnNetworkError = false


    fun  setShouldReturnNetworkError(value:Boolean){
        shouldReturnNetworkError = value
    }

    private fun refreshLiveDate(){
        observableProductItems.postValue(productItems)
    }

    override suspend fun insertProductItem(productEntity: ProductEntity) {
        productItems.add(productEntity)
        refreshLiveDate()

    }

    override suspend fun deleteProductItem(productEntity: ProductEntity) {
        productItems.remove(productEntity)
        refreshLiveDate()
    }

    override fun getAllProducts(): LiveData<List<ProductEntity>> {
        return observableProductItems
    }

    override fun getProductByID(productID: Int): LiveData<ProductEntity> {


    }


}