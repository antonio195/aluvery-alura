package com.antoniocostadossantos.alurevy_alura.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.antoniocostadossantos.alurevy_alura.ui.components.CardProductItem
import com.antoniocostadossantos.alurevy_alura.ui.components.ProductSection
import com.antoniocostadossantos.alurevy_alura.ui.components.SearchTextField
import com.antoniocostadossantos.alurevy_alura.ui.viewmodel.HomeScreenUiState
import com.antoniocostadossantos.alurevy_alura.ui.viewmodel.HomeScreenViewModel



@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel
) {
    val state by viewModel.uiState.collectAsState()

    HomeScreen(state = state)
}

@Composable
fun HomeScreen(
    state: HomeScreenUiState = HomeScreenUiState()
) {
    val text = state.searchText
    val searchedProducts = state.searchedProducts
    val sections = state.sections

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