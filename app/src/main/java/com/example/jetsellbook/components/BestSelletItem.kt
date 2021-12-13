package com.example.jetsellbook.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetsellbook.R


@Preview
@Composable
fun BestSellerItemPreview() {
    BestSellerItem(
        "Hoang Trung Quan",
        123, 12,
        painterResource(id = R.drawable.background_login)
    )
}

@Composable
fun BestSellerItem(
    name: String = "",
    price: Int = 0,
    discountPercent: Int = 0,
    imagePainter: Painter
) {
    val context = LocalContext.current
    Card(
        Modifier
            .width(190.dp)
            .padding(end = 10.dp)
            .clickable { }
            .shadow(elevation = 2.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 0.dp
    ) {
        Column(
            Modifier
                .padding(bottom = 10.dp)
                .height(260.dp)
        ) {
            Image(
                painter = imagePainter,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp)
                    .aspectRatio(1f)
                    .graphicsLayer {
                        shape = RoundedCornerShape(
                            bottomStart = 10.dp,
                            bottomEnd = 10.dp
                        )
                        clip = true
                    },
                contentScale = ContentScale.Crop
            )
            Row(
                modifier = Modifier
                    .padding(
                        start = 8.dp,
                        top = 70.dp,
                        end = 8.dp
                    )
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = name,
                        style = TextStyle(
                            color = Color.Gray,
                            fontSize = 13.sp
                        )
                    )
                    Text(
                        text = "${price} VND",
                        style = TextStyle(
                            color = Color.DarkGray,
                            fontSize = 12.sp
                        ),
                    )
                }
                IconButton(
                    onClick = { JetSellBookRouter.navigateTo(Screen.CartPage) },
                    modifier = Modifier
                        .background(
                            color = Color.DarkGray,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .size(50.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.ShoppingCart,
                        contentDescription = "Shopping cart",
                        tint = Color(0xFFCC3333),
                        modifier = Modifier
                            .size(23.dp)
                    )
                }
            }

        }
    }
}