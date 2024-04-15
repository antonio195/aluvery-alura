package com.antoniocostadossantos.dao

import androidx.compose.runtime.mutableStateListOf
import com.antoniocostadossantos.alurevy_alura.data.sample.sampleProducts
import com.antoniocostadossantos.alurevy_alura.model.Product

class ProductDao {

    companion object {
        private val products = mutableStateListOf(*sampleProducts.toTypedArray())
    }

    fun getProducts() = products.toList()

    fun saveProduct(product: Product) = products.add(product)

}