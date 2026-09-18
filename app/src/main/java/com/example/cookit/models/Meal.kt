package com.example.cookit.models

import com.example.cookit.AppConstants
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class Meal(
    val idMeal: String,
    @SerialName(AppConstants.mealNameKey)
    val name: String,
    @SerialName(AppConstants.mealImageKey)
    val imageUrl: String,
)