package com.antoniocostadossantos.alurevy_alura.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.antoniocostadossantos.alurevy_alura.R
import com.antoniocostadossantos.alurevy_alura.data.sample.sampleProducts
import com.antoniocostadossantos.alurevy_alura.model.Product
import com.antoniocostadossantos.alurevy_alura.ui.theme.AlurevyaluraTheme
import java.math.BigDecimal

@Composable
fun CardProductItem(
    product: Product,
    modifier: Modifier = Modifier,
    elevation: Dp = 10.dp
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(150.dp),
        elevation = CardDefaults.cardElevation(elevation)
    ) {
        Column {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(100.dp),
                model = product.image,
                contentDescription = null,
                placeholder = painterResource(id = R.drawable.placeholder),
                contentScale = ContentScale.Fit
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .padding(16.dp)
            ) {
                Text(
                    text = product.name
                )
                Text(
                    text = "R$ ${product.price}"
                )
            }
            product.description?.let {
                Text(
                    text = it,
                    Modifier
                        .padding(16.dp)
                )
            }

        }
    }
}

@Preview
@Composable
private fun CardProductItemPreview() {
    AlurevyaluraTheme {
        Surface {
            CardProductItem(
                product = sampleProducts.first(),
            )
        }
    }
}

@Preview
@Composable
private fun CardProductItemWithDescriptionPreview() {
    AlurevyaluraTheme {
        Surface {
            CardProductItem(
                product = Product(
                    name = "Batata Frita",
                    price = BigDecimal("12.99"),
                    description = LoremIpsum(50).values.first(),
                ),
            )
        }
    }
}