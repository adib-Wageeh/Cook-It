package com.example.cookit.network

import com.example.cookit.AppConstants
import com.example.cookit.models.CategoriesResponse
import com.example.cookit.models.MealsResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface MealsCallable {

    @GET(AppConstants.categorys)
    fun getCategories(): Call<CategoriesResponse>

    @GET(AppConstants.mealsForSpecificCategory)
    fun getMealsForSpecificCategory(
        @Query("c") categoryName: String
    ): Call<MealsResponse>
}

fun getCallable(): MealsCallable {
    val retroFit = Retrofit.Builder()
        .baseUrl(AppConstants.baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    return retroFit.create(MealsCallable::class.java)

}