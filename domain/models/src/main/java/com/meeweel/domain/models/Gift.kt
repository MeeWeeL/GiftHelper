package com.meeweel.domain.models

data class Gift(
    val id: Int,
    val title: String,
    val description: String,
    val price: Int,
    val imageUrl: String? = null,
    val ozonUrl: String? = null,
)
