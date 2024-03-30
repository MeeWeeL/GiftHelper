package com.meeweel.data.impl.models

data class GiftOfferRequest(
    val title: String,
    val description: String,
    val price: Int,
    val ozonUrl: String?,
    val image: String?,
)
