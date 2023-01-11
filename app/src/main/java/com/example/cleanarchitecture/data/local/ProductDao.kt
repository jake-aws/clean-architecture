package com.example.cleanarchitecture.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDao {

    @Insert
    suspend fun insertProduct(productEntity: ProductEntity)

    @Delete
    suspend fun deleteProduct(productEntity: ProductEntity)

    @Query("SELECT * FROM product_items")
    fun getAllProducts():LiveData<List<ProductEntity>>

    @Query("SELECT * FROM product_items WHERE product_items.id = :productId")
    fun getProduct(productId:Int): LiveData<ProductEntity>
}