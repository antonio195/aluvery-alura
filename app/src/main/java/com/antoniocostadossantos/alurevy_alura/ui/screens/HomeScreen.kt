package com.antoniocostadossantos.alurevy_alura.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.antoniocostadossantos.alurevy_alura.R
import com.antoniocostadossantos.alurevy_alura.data.sample.sampleProducts
import com.antoniocostadossantos.alurevy_alura.model.Product
import com.antoniocostadossantos.alurevy_alura.ui.components.ProductItem
import com.antoniocostadossantos.alurevy_alura.ui.components.ProductSection
import java.math.BigDecimal

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(Modifier)
        ProductSection(title = "Promoções", sampleProducts)
        ProductSection(title = "Doces", sampleProducts)
        ProductSection(title = "Bebidas", sampleProducts)
        Spacer(Modifier)
    }
}