package com.example.cookit.models

import com.google.gson.annotations.SerializedName

class Category(
   val idCategory: String,
   @SerializedName("strCategory")
   val name: String,
   @SerializedName("strCategoryThumb")
   val imageUrl: String,
   @SerializedName("strCategoryDescription")
   val description: String,
)