package com.meeweel.core.ui_components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.meeweel.core.ui_base.theme.MeTheme

@Composable
fun MeCard(
    @SuppressLint("ModifierParameter")
    modifier: Modifier = Modifier
        .height(180.dp)
        .width(120.dp),
    backgroundColor: Color = MeTheme.colors.cardBackground,
    isClickable: Boolean = true,
    onClick: (() -> Unit)? = null,
    cornerRadius: Dp = 20.dp,
    contentAlignment: Alignment = Alignment.Center,
    content: @Composable () -> Unit = {},
) = Card(
    shape = RoundedCornerShape(cornerRadius),
    colors = CardDefaults.cardColors(
        containerColor = Color.Transparent,
    )
) {
    Box(
        modifier = modifier
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        backgroundColor,
                        Color.Transparent,
                    )
                )
            )
            .clickable(enabled = isClickable) { onClick?.let { it() } },
        contentAlignment = contentAlignment,
    ) {
        content()
    }
}

@Composable
@Preview(showBackground = true)
fun MeCardPreview() {
    MeCard()
}