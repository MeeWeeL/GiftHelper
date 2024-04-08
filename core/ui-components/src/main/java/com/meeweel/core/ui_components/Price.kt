package com.meeweel.core.ui_components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.meeweel.core.ui_base.theme.MeTheme

@Composable
fun Price(
    price: Int,
    modifier: Modifier = Modifier,
) {
    Text(
        text = "$price ₽",
        style = MeTheme.typography.priceText,
    )
}

@Composable
@Preview(showBackground = true)
fun PricePreview() {
    Price(100)
}