package com.example.cookit.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.cookit.models.Category
import com.example.cookit.ui.theme.MintGreen
import com.example.cookit.ui.theme.Orange
import com.example.cookit.ui.theme.Pink
import com.example.cookit.ui.theme.Purple
import com.example.cookit.ui.theme.SkyBlue
import com.example.cookit.ui.theme.SoftPink
import com.example.cookit.ui.theme.Yellow

@Composable
fun CategoryItem(
    category: Category,
    modifier: Modifier = Modifier,
    categoryPressed: () -> Unit,
) {


    Column(
        modifier = modifier
            .padding(8.dp)
            .width(96.dp)
            .clickable {
                categoryPressed()
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = category.imageUrl,
            contentDescription = category.name,
            modifier = Modifier
                .size(96.dp)
                .clip(CircleShape)
                .border(
                    width = 4.dp,
                    brush = Brush.sweepGradient(
                        colors = listOf(
                            SoftPink,
                            Orange,
                            Yellow,
                            MintGreen,
                            SkyBlue,
                            Purple,
                            Pink,
                        )
                    ),
                    shape = CircleShape
                ),
            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            category.name,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold
        )
    }
}