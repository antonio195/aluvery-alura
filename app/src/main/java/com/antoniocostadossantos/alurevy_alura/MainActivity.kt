package com.antoniocostadossantos.alurevy_alura

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.antoniocostadossantos.alurevy_alura.ui.components.ProductSection
import com.antoniocostadossantos.alurevy_alura.ui.screens.HomeScreen
import com.antoniocostadossantos.alurevy_alura.ui.theme.AlurevyaluraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    AlurevyaluraTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            HomeScreen()
        }
    }
}

