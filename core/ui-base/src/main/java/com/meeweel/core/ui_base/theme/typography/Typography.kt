package com.meeweel.core.ui_base.theme.typography

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val HeaderText = TextStyle(
    fontFamily = null,
    fontWeight = FontWeight.ExtraBold,
    fontSize = 24.sp,
    lineHeight = 28.sp,
)
val TitleText = TextStyle(
    fontFamily = null,
    fontWeight = FontWeight.SemiBold,
    fontSize = 18.sp,
    lineHeight = 20.sp,
)
val PrimaryText = TextStyle(
    fontFamily = null,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    lineHeight = 18.sp,
)
val SecondaryText = TextStyle(
    fontFamily = null,
    fontWeight = FontWeight.ExtraLight,
    fontSize = 16.sp,
    lineHeight = 18.sp,
)
val PriceText = TextStyle(
    fontFamily = null,
    fontWeight = FontWeight.Light,
    fontSize = 16.sp,
    lineHeight = 18.sp,
)

object MeTypography {

    val typography: Typography = Typography()
    val headerText: TextStyle = HeaderText
    val titleText: TextStyle = TitleText
    val primaryText: TextStyle = PrimaryText
    val secondaryText: TextStyle = SecondaryText
    val priceText: TextStyle = PriceText
}