package com.meeweel.data.impl.models

import android.net.Uri
import com.meeweel.domain.models.Gift

data class GiftResponse(
    val id: Int,
    val title: String,
    val description: String,
    val price: Int,
    val imageUrl: String? = null,
    val ozonUrl: String? = null,
) {

    fun toModel() = Gift(
        id = id,
        title = title,
        description = description,
        price = price,
        imageUrl = imageUrl,
        ozonUri = try {
            Uri.parse(ozonUrl)
        } catch (e: Exception) {
            null
        },
    )
}