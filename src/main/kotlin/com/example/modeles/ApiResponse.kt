package com.example.modeles

import kotlinx.serialization.Serializable


@Serializable
data class ApiResponse(
    val success: Boolean,
    val message: String? = null,
    val prevPage: Int? = null,
    val nextPage: Int? = null,
    val heroes: List<Instrument> = emptyList(),
    val lastUpdated: Long? = null
)
