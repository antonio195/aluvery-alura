package com.antoniocostadossantos.alurevy_alura.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.antoniocostadossantos.alurevy_alura.ui.theme.DarkGrey
import java.math.BigDecimal
import kotlin.math.exp

@Composable
fun CardProductItem(
    product: Product,
    modifier: Modifier = Modifier,
    elevation: Dp = 10.dp,
    isExpanded: Boolean = false
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(150.dp),
        elevation = CardDefaults.cardElevation(elevation)
    ) {

        var expanded by rememberSaveable { mutableStateOf(isExpanded) }

        Column {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)

                    .heightIn(100.dp)
                    .clickable {
                        expanded = !expanded
                    },
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
            if (expanded) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(1.dp)
                        .padding(horizontal = 16.dp)
                        .background(color = DarkGrey)
                )
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