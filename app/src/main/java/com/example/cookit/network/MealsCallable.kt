package com.example.cookit.network

import com.example.cookit.AppConstants
import com.example.cookit.models.CategoriesResponse
import com.example.cookit.models.MealsResponse
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import kotlinx.serialization.json.Json


interface MealsCallable {

    @GET(AppConstants.categorys)
    fun getCategories(): Call<CategoriesResponse>

    @GET(AppConstants.mealsForSpecificCategory)
    fun getMealsForSpecificCategory(
        @Query("c") categoryName: String
    ): Call<MealsResponse>
}

fun getCallable(): MealsCallable {
    val json = Json { ignoreUnknownKeys = true } // recommended: tolerate extra API fields

    val retrofit = Retrofit.Builder()
        .baseUrl(AppConstants.baseUrl)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()

    return retrofit.create(MealsCallable::class.java)
}