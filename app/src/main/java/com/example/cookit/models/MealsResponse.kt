package com.example.cookit.models

import kotlinx.serialization.Serializable


@Serializable
data class MealsResponse(
    val meals: List<Meal>
)