package com.antoniocostadossantos.alurevy_alura.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.antoniocostadossantos.alurevy_alura.data.sample.sampleSections
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
            HomeScreen(sampleSections)
        }
    }
}

