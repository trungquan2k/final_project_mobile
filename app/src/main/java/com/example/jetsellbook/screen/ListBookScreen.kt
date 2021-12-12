package com.example.jetsellbook.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter

import com.example.jetsellbook.viewmodel.MainViewModel
import com.example.jetsellbook.R
@Composable
fun ListBookScreen(viewModel: MainViewModel) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            text = "New & Trending",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.colorPrimary)
        )
        Spacer(modifier = Modifier.height(8.dp))
        if (viewModel.errorMessage.isEmpty()) {
            LazyRow {
                items(viewModel.bookList) { book ->
                    Card(
                        Modifier
                            .width(160.dp)
                            .clickable { }
                            .shadow(elevation = 2.dp),
                        shape = RoundedCornerShape(15.dp)
                    ) {
                        Column(
                            Modifier
                                .padding(bottom = 32.dp)
                        ) {
                            Image(
                                painter = rememberImagePainter(book.image),
                                contentDescription = "",
                                modifier = Modifier
                                    .width(100.dp)
                                    .aspectRatio(1f)
                                    .height(100.dp),
                                contentScale = ContentScale.Fit
                            )
                            Column(
                                Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 8.dp)
                            ) {
                                Text(text = book.book_name, fontWeight = FontWeight.Bold)
                                Row {
                                    Text(
                                        "${book.price}",
//                                        textDecoration = if (book.price_promotion > 0.toString())
//                                            TextDecoration.LineThrough
//                                        else
//                                            TextDecoration.None,
//                                        color = if (book.price_promotion > 0.toString()) Color.Gray else Color.Black
                                    )
//                                    if (book.price_promotion > 0.toString()) {
//                                        Text(text = "[$book.price_promotion%]", color = MaterialTheme.colors.primary)
//                                    }
                                }
                            }
                        }
                    }
//                    Card(
//                        modifier = Modifier
//                            .clickable { }
//                            .shadow(elevation = 2.dp),
//                        shape = RoundedCornerShape(15.dp)
//                    ) {
//                        Column(
//                            modifier = Modifier
//                            .height(200.dp)
//                            .width(150.dp)
//                        ) {
//                            Box() {
//                                Image(
//                                    painter = rememberImagePainter(book.image),
//                                    contentDescription = "",
//                                    contentScale = ContentScale.Fit,
//                                    modifier = Modifier.fillMaxWidth()
//                                )
//                            }
//                            Box(
//                                modifier = Modifier
//                                    .fillMaxSize()
//                                    .padding(12.dp),
//                                contentAlignment = Alignment.BottomCenter
//                            ) {
//                                Text(
//                                    text = book.book_name,
//                                    style = TextStyle(color = Color.Black, fontSize = 16.sp)
//                                )
//                            }
//                            Text(
//                                text = book.price,
//                                style = TextStyle(color = Color.Black, fontSize = 16.sp)
//                            )
//                        }
//                    }
                }
            }
        } else {
            viewModel.errorMessage
        }
    }

}