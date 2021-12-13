package com.example.jetsellbook.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

import com.example.jetsellbook.viewmodel.MainViewModel

@Composable
fun SearchScreen(viewModel: MainViewModel) {
    Column() {
        ClientSearchCard(viewModel)
        ContentSearch(viewModel)
    }

}

@Composable
fun ClientSearchCard(viewModel: MainViewModel) {
    var searchText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {

        TextField(
            value = searchText,
            onValueChange = {
                searchText = it
                viewModel.searchBooks(searchText)
            },
            label = { Text("Search:") },
            modifier = Modifier.fillMaxWidth()
        )

    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ContentSearch(viewModel: MainViewModel) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        // content padding
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 8.dp,
            end = 12.dp,
            bottom = 16.dp
        ),
        content = {
            if (viewModel.errorMessage.isEmpty()) {
                items(viewModel.bookList) { book ->
                    val context = LocalContext.current
                    Card(
                        Modifier
                            .width(220.dp)
                            .padding(end = 10.dp, top = 20.dp)
                            .clickable { }
                            .shadow(elevation = 2.dp),
                        shape = RoundedCornerShape(8.dp),
                        elevation = 0.dp
                    ) {
                        Column(
                            Modifier
                                .padding(bottom = 10.dp)
                        ) {
                            Image(
                                painter = rememberImagePainter(book.image),
                                contentDescription = "",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .aspectRatio(1f),
                                contentScale = ContentScale.Crop
                            )
                            Column(
                                Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 8.dp)
                            ) {
                                Text(text = book.book_name)
                                Spacer(modifier = Modifier.height(10.dp))
                                Row {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    ) {
                                        Text(
                                            "${book.price} VND",
                                            modifier = Modifier.align(Alignment.BottomStart)
                                        )
                                        Icon(
                                            imageVector = Icons.Filled.ShoppingCart,
                                            contentDescription = "Shopping cart",
                                            tint = Color(0xFFCC3333),
                                            modifier = Modifier
                                                .align(Alignment.BottomEnd)
                                                .clickable {

                                                }
                                                .size(23.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                viewModel.errorMessage
            }
        }
    )
}