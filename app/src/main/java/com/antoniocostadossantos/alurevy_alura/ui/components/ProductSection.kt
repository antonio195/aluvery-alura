package com.antoniocostadossantos.alurevy_alura.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.antoniocostadossantos.alurevy_alura.R
import com.antoniocostadossantos.alurevy_alura.model.Product
import java.math.BigDecimal

@Composable
fun ProductSection(title: String, products: List<Product>) {
    Column() {
        Text(
            text = title,
            fontWeight = FontWeight(400),
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            fontSize = 20.sp
        )
        Row(
            Modifier
                .padding(top = 8.dp)
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Spacer(Modifier)
            products.forEach {
                ProductItem(product = it)
            }
            Spacer(Modifier)
        }
    }
}