package com.antoniocostadossantos.alurevy_alura.model

import androidx.annotation.DrawableRes
import com.antoniocostadossantos.alurevy_alura.R
import java.math.BigDecimal

data class Product(
    val name: String,
    val price: BigDecimal,
    @DrawableRes val image: Int = R.drawable.ic_launcher_background
)
