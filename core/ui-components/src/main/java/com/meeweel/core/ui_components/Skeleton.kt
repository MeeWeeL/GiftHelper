package com.meeweel.core.ui_components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.meeweel.core.ui_base.shimmerEffect

@Composable
fun Skeleton(
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 8.dp,
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(cornerRadius),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Transparent)
                .shimmerEffect(),
        ) {

        }
    }
}

@Composable
@Preview(showBackground = true)
fun SkeletonPreview() {
    Skeleton(
        modifier = Modifier
            .height(80.dp)
            .width(120.dp),
    )
}