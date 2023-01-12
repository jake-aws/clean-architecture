package com.example.cleanarchitecture.presentation.viewModels

import androidx.lifecycle.ViewModel
import com.example.cleanarchitecture.data.local.ProductDB
import com.example.cleanarchitecture.domain.repositories.ProductService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor (
    private val respository:ProductService
        ):ViewModel() {
}

