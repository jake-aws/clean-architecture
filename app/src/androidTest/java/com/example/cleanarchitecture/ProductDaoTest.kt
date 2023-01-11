package com.example.cleanarchitecture

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.cleanarchitecture.data.local.ProductDB
import com.example.cleanarchitecture.data.local.ProductDao
import com.example.cleanarchitecture.data.local.ProductEntity
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class ProductDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: ProductDB
    private lateinit var dao: ProductDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            ProductDB::class.java
        ).allowMainThreadQueries().build()
        dao = database.productDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertProductTestSuccess() = runTest {
        val productEntity = ProductEntity(
            brand = "brang",
            category = "something",
            description = "description",
            discountPercentage = 0.9,
            id = 1
        )
        dao.insertProduct(productEntity)

        val allProductEntity = dao.getAllProducts().getOrAwaitValue()
        assertThat(allProductEntity).contains(productEntity)
    }

    @Test
    fun getProductTestSuccess() = runTest {
        val productEntity = ProductEntity(
            brand = "brang",
            category = "something",
            description = "description",
            discountPercentage = 0.9,
            id = 1
        )

        dao.insertProduct(productEntity)

        val allProductEntity = dao.getProduct(1).getOrAwaitValue()
        assertThat(allProductEntity).isEqualTo(productEntity)
    }

}