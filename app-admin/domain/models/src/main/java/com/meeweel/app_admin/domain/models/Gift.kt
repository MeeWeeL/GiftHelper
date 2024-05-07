package com.meeweel.app_admin.domain.models

import android.net.Uri

data class Gift(
    val id: Int,
    val title: String,
    val description: String,
    val price: Int,
    val imageUrl: String? = null,
    val ozonUri: Uri? = null,
    val state: State,
)

enum class State {
    RELEASE, MODERATION
}