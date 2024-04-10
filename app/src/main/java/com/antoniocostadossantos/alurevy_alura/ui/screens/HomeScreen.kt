package com.antoniocostadossantos.alurevy_alura.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.antoniocostadossantos.alurevy_alura.data.sample.sampleProducts
import com.antoniocostadossantos.alurevy_alura.model.Product
import com.antoniocostadossantos.alurevy_alura.ui.components.CardProductItem
import com.antoniocostadossantos.alurevy_alura.ui.components.ProductSection
import com.antoniocostadossantos.alurevy_alura.ui.components.SearchTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    sections: Map<String, List<Product>>,
    searchText: String = ""
) {

    Column {
        var text by remember { mutableStateOf(searchText) }

        SearchTextField(
            searchText = text,
            onSearchTextChange = { text = it},
        )

        val searchedProducts = remember(text) {
            if (text.isNotBlank()) {
                sampleProducts.filter { product ->
                    product.name.contains(text, ignoreCase = true) || product.description?.contains(
                        text,
                        ignoreCase = true
                    ) ?: false
                }
            } else emptyList()
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {

            if (text.isBlank()) {
                sections.forEach {
                    val title = it.key
                    val product = it.value
                    item {
                        ProductSection(title = title, products = product)
                    }
                }
            } else {
                items(searchedProducts) {
                    CardProductItem(
                        product = it,
                        modifier = Modifier.padding(start = 16.dp, top = 8.dp, end = 16.dp)
                    )
                }
            }
        }
    }
}