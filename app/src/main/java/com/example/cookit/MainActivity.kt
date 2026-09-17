package com.example.cookit

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.cookit.models.CategoriesResponse
import com.example.cookit.models.Category
import com.example.cookit.network.getCallable
import com.example.cookit.ui.HomeScreen
import com.example.cookit.ui.theme.CookItTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            var categories by remember { mutableStateOf<List<Category>>(emptyList()) }
            var isLoading by remember { mutableStateOf(true) }
            var error by remember { mutableStateOf(false) }

            LaunchedEffect(Unit) {
                getCallable().getCategories().enqueue(
                    object : Callback<CategoriesResponse> {
                        override fun onResponse(
                            call: Call<CategoriesResponse>,
                            response: Response<CategoriesResponse>
                        ) {
                            isLoading = false
                            if (response.isSuccessful) {
                                error = false
                                categories = response.body()?.categories ?: emptyList()
                            } else {
                                Log.d("error_tag", response.code().toString())
                                error = true
                            }
                        }

                        override fun onFailure(call: Call<CategoriesResponse>, t: Throwable) {
                            isLoading = false
                            Log.d("error_tag", t.message.toString())
                            error = true
                        }
                    }
                )
            }

            CookItTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(
                        categories = categories,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
