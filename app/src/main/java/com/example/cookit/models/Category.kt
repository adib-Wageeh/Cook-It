package com.example.cookit.models

import com.example.cookit.AppConstants
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class Category(
    val idCategory: String,
    @SerialName(AppConstants.categoryNameKey)
    val name: String,
    @SerialName(AppConstants.categoryImageKey)
    val imageUrl: String,
    @SerialName(AppConstants.categoryDescriptionKey)
    val description: String,
)