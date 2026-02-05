package com.nutrifysports.shared.domain

import kotlinx.serialization.Serializable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid
@Serializable
data class CartItem @OptIn(ExperimentalUuidApi::class) constructor(
    val id: String = Uuid.random().toHexDashString(),
    val productId: String,
    val flavour: String? = null,
    val quantity: Int
)
