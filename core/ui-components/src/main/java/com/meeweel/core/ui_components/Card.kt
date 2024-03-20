package com.meeweel.core.ui_components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.meeweel.ui_base.shimmerEffect
import com.meeweel.ui_base.theme.MeTheme

@Composable
fun MeCard(
    @SuppressLint("ModifierParameter")
    modifier: Modifier = Modifier
        .height(180.dp)
        .width(120.dp),
    backgroundColor: Color? = MeTheme.colors.cardBackground,
    backgroundPadding: Dp = 8.dp,
    isClickable: Boolean = true,
    onClick: (() -> Unit)? = null,
    isSoon: Boolean = false,
    isLoading: Boolean = false,
    cornerRadius: Dp = 20.dp,
    marginAll: Dp = 0.dp,
    marginHorizontal: Dp = 0.dp,
    marginVertical: Dp = 0.dp,
    underCardContent: @Composable ColumnScope.() -> Unit = {},
    underCardSpace: Dp = 0.dp,
    contentAlignment: Alignment = Alignment.Center,
    content: @Composable BoxScope.() -> Unit = {},
) {
    Column(
        modifier = Modifier
            .padding(all = marginAll)
            .padding(horizontal = marginHorizontal)
            .padding(vertical = marginVertical)
    ) {
        Card(
            shape = RoundedCornerShape(cornerRadius)
        ) {
            Box(
                modifier = modifier
                    .background(color = if (isLoading) Color.Transparent else backgroundColor ?: Color.White)
                    .shimmerEffect(isLoading)
                    .clickable(enabled = isClickable && !isLoading) { onClick?.let { it() } }
                    .padding(all = backgroundPadding),
                contentAlignment = contentAlignment,
            ) {
                content()
                if (isSoon) {
                    Image(
                        modifier = Modifier
                            .width(56.dp)
                            .align(Alignment.TopStart),
                        painter = painterResource(id = R.drawable.ic_soon),
                        contentDescription = null
                    )
                }
            }
        }
        underCardContent()
    }
}

@Composable
@Preview(showBackground = true)
fun MeCardPreview() {
    MeCard()
}