package com.example.cleanarchitecture.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ProductEntity::class], version = 1)
abstract class ProductDB :RoomDatabase(){

    abstract fun productDao(): ProductDao
}