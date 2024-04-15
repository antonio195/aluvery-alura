package com.antoniocostadossantos.alurevy_alura.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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

class HomeScreenUiState(searchText: String = "") {

    var text by mutableStateOf(searchText)
        private set

    val searchedProducts
        get() =
            if (text.isNotBlank()) {
                sampleProducts.filter { product ->
                    product.name.contains(text, ignoreCase = true) || product.description?.contains(
                        text,
                        ignoreCase = true
                    ) ?: false
                }
            } else emptyList()

    val showSections get() = text.isBlank()

    val onSearchChange: (String) -> Unit = {
        text = it
    }
}


@Composable
fun HomeScreen(
    sections: Map<String, List<Product>>,
    state: HomeScreenUiState = HomeScreenUiState()
) {
    val text = state.text
    val searchedProducts = remember(text) { state.searchedProducts }

    Column {

        SearchTextField(
            searchText = text,
            onSearchTextChange = state.onSearchChange,
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {

            if (state.showSections) {
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