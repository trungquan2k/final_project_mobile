package com.example.jetsellbook.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.jetsellbook.R
import com.example.jetsellbook.components.BestSellerItem
import com.example.jetsellbook.viewmodel.MainViewModel

@Composable
fun New_Trend(viewModel: MainViewModel) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            text = "Sản phẩm mới nhất ",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.colorPrimary)
        )
        Spacer(modifier = Modifier.height(8.dp))
        if (viewModel.errorMessage.isEmpty()) {
            LazyRow {
                items(viewModel.bookList) { book ->
                    BestSellerItem(
                        name=book.book_name,
                        imagePainter= rememberImagePainter(book.image),
                        price=book.price,
                        discountPercent = book.price_promotion
                    )
                }
            }
        } else {
            viewModel.errorMessage
        }
    }

}