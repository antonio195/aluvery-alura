package com.antoniocostadossantos.alurevy_alura.data.sample

import com.antoniocostadossantos.alurevy_alura.R
import com.antoniocostadossantos.alurevy_alura.model.Product
import java.math.BigDecimal

val sampleProducts = listOf(
    Product(
        name = "Hamburger",
        price = BigDecimal("12.99"),
        image = R.drawable.hamburger
    ),
    Product(
        name = "Fritas",
        price = BigDecimal("8.99"),
        image = R.drawable.fritas
    ),
    Product(
        name = "Pizza",
        price = BigDecimal("16.74"),
        image = R.drawable.pizza
    )
)
