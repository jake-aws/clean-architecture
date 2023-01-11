package com.example.cleanarchitecture.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_items")
data class ProductEntity(
    @ColumnInfo val brand: String,
    @ColumnInfo val category: String,
    @ColumnInfo val description: String,
    @ColumnInfo val discountPercentage: Double,
    @PrimaryKey(autoGenerate = false)val id: Int,
) {
}