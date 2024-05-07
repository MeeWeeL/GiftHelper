package com.meeweel.app_admin.data.impl.models

import android.net.Uri
import com.meeweel.app_admin.domain.models.Gift
import com.meeweel.app_admin.domain.models.State

data class GiftResponse(
    val id: Int,
    val title: String,
    val description: String,
    val price: Int,
    val imageUrl: String? = null,
    val ozonUrl: String? = null,
    val isRelease: Boolean,
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
        state = if (isRelease) State.RELEASE else State.MODERATION,
    )
}