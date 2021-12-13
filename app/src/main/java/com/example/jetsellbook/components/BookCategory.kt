package com.example.jetsellbook.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BookCategories(
    text: String = "",
    image: Painter,
    backgroundColor: Color
) {
    Column(
        Modifier
            .width(72.dp)
            .clickable { },

    ) {
        Box(
            Modifier
                .size(72.dp)
                .background(
                    color = backgroundColor,
                    shape = RoundedCornerShape(12.dp)
                )
        ) {
            Image(
                painter = image,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                    color = Color.DarkGray,
                    shape = RoundedCornerShape(10.dp)
                ),
                contentScale = ContentScale.Crop,
            )
        }
        Text(text = text, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 15.sp)
    }
}