package com.example.cookit.ui

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.cookit.models.Category
import com.example.cookit.models.Meal
import com.example.cookit.models.MealsResponse
import com.example.cookit.network.getCallable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun HomeScreen(categories: List<Category>, modifier: Modifier = Modifier) {

    var selectedCategory by remember { mutableStateOf<Category?>(null) }
    var meals by remember { mutableStateOf<List<Meal>>(emptyList()) }

    LaunchedEffect(selectedCategory) {
        if (selectedCategory != null)
            getCallable().getMealsForSpecificCategory(selectedCategory!!.name).enqueue(
                object : Callback<MealsResponse> {
                    override fun onResponse(
                        call: Call<MealsResponse>,
                        response: Response<MealsResponse>
                    ) {
                        if (response.isSuccessful) {
                            meals = response.body()?.meals ?: emptyList()
                        } else {
                            Log.d("error_tag", response.code().toString())
                        }
                    }

                    override fun onFailure(call: Call<MealsResponse>, t: Throwable) {
                        Log.d("error_tag", t.message.toString())
                    }
                }
            )
    }

    Column(modifier = modifier) {
        LazyRow(modifier = modifier) {
            items(categories) {
                CategoryItem(it) { category ->
                    if (selectedCategory?.idCategory != category.idCategory) {
                        selectedCategory = category
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(18.dp))
        if (selectedCategory == null)
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "Select a category to show available meals",
                    textAlign = TextAlign.Center,
                )
            }
        else
            LazyVerticalGrid(
                columns = GridCells.Fixed(2)
            ) {
                items(meals) {
                    MealItem(it)
                }
            }
    }
}