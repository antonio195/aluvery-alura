package com.antoniocostadossantos.alurevy_alura.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.antoniocostadossantos.alurevy_alura.data.sample.sampleCandies
import com.antoniocostadossantos.alurevy_alura.data.sample.sampleDrinks
import com.antoniocostadossantos.alurevy_alura.ui.screens.HomeScreen
import com.antoniocostadossantos.alurevy_alura.ui.screens.HomeScreenUiState
import com.antoniocostadossantos.alurevy_alura.ui.theme.AlurevyaluraTheme
import com.antoniocostadossantos.dao.ProductDao

class MainActivity : ComponentActivity() {

    private val dao = ProductDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(
                onFabClick = {
                    startActivity(Intent(this, ProductFormActivity::class.java))
                },
                content = {
                    val sections = mapOf(
                        "Todos produtos" to dao.getProducts(),
                        "Promoções" to sampleCandies + sampleDrinks,
                        "Doces" to sampleCandies,
                        "Bebidas" to sampleDrinks,
                    )
                    val state = remember { HomeScreenUiState() }
                    HomeScreen(sections = sections, state = state)
                },
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(
    onFabClick: () -> Unit = {},
    content: @Composable () -> Unit = {}
) {
    AlurevyaluraTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            Scaffold(floatingActionButton = {
                FloatingActionButton(onClick = { onFabClick() }) {
                    Icon(Icons.Outlined.Add, contentDescription = null)
                }
            }) { paddingValues ->
                Box(modifier = Modifier.padding(paddingValues)) {
                    content()
                }
            }
        }
    }
}

