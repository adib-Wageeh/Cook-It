package com.example.cookit.models

import com.google.gson.annotations.SerializedName

class Meal(
    val idMeal: String,
    @SerializedName("strMeal")
    val name: String,
    @SerializedName("strMealThumb")
    val imageUrl: String,
)