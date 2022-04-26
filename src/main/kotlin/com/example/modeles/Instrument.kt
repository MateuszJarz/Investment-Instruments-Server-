package com.example.modeles

import kotlinx.serialization.Serializable

@Serializable
data class Instrument(
    val id: Int,
    val image: String,
    val about: String,
    val rating: Double, // 0-5

    val family: List<String>,

)
