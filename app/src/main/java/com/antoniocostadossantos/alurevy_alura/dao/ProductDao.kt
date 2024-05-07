package com.antoniocostadossantos.alurevy_alura.dao

import androidx.compose.runtime.mutableStateListOf
import com.antoniocostadossantos.alurevy_alura.data.sample.sampleProducts
import com.antoniocostadossantos.alurevy_alura.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.toList

class ProductDao {

    companion object {
        private val products = MutableStateFlow<List<Product>>(emptyList())
    }

    fun getProducts() = products.asStateFlow()

    fun saveProduct(product: Product) {
        products.value = products.value + product
    }

}