package com.example.cookit.models

import kotlinx.serialization.Serializable


@Serializable
data class CategoriesResponse(
    val categories: List<Category>
)