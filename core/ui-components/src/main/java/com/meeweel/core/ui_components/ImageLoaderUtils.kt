package com.meeweel.core.ui_components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import coil.compose.rememberAsyncImagePainter

@Composable
fun loadImage(model: Any?) = rememberAsyncImagePainter(
    model = model ?: R.drawable.ic_gift_image_default,
    placeholder = painterResource(id = R.drawable.ic_soon),
    error = painterResource(id = R.drawable.ic_gift_image_error),
)