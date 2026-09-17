package com.example.cookit.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.cookit.models.Meal
import com.example.cookit.ui.theme.LightGray

@Composable
fun MealItem(
    meal: Meal,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .padding(12.dp)
    ) {
        Box(
            modifier = Modifier
                .size(
                    width = 174.dp,
                    height = 214.dp
                )
                .padding(top = 64.dp)
                .clip(RoundedCornerShape(size = 12.dp))
                .background(LightGray)
                .align(Alignment.Center)
                .clickable{}
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            AsyncImage(
                model = meal.imageUrl,
                contentDescription = meal.name,
                modifier = Modifier
                    .size(
                        width = 96.dp,
                        height = 128.dp
                    )
                    .clip(RoundedCornerShape(size = 12.dp)),
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.height(18.dp))
            Text(
                meal.name,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold
            )
        }

    }
}