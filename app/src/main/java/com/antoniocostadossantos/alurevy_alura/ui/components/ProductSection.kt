package com.antoniocostadossantos.alurevy_alura.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.antoniocostadossantos.alurevy_alura.model.Product

@Composable
fun ProductSection(title: String, modifier: Modifier = Modifier, products: List<Product>) {
    Column(modifier) {
        Text(
            text = title,
            fontWeight = FontWeight(400),
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            fontSize = 20.sp
        )
        LazyRow(
            Modifier
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(products) {
                ProductItem(product = it)
            }
        }
    }
}