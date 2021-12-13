package com.example.jetsellbook.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import kotlin.random.Random
import com.example.jetsellbook.R


@ExperimentalMaterialApi
@Composable
fun ProductCart() {
    Card(
        shape = RoundedCornerShape(4.dp),
        backgroundColor = Color(0xffFDF5E6)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Row() {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.baseline_shopping_cart_24),
                    contentDescription = "",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(20.dp)
                        .padding(top = 3.dp)
                )
                Text(
                    text = "Mặt hàng đã chọn",
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 17.sp
                    ),
                    modifier = Modifier.height(20.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Orders(
                text = "Đời sống",
                price = 100000,
                image = painterResource(id = R.drawable.dich),
                backgroundColor = Color(0xffFDF5E6)
            )
            Divider()
            Orders(
                text = "Tinh cảm",
                price = 150000,
                image = painterResource(id = R.drawable.tinh_cam),
                backgroundColor = Color(0xffFDF5E6)
            )
            Divider()
            Orders(
                text = "Đắc nhân tâm",
                price = 120000,
                image = painterResource(id = R.drawable.dac_nhan_tam),
                backgroundColor = Color(0xffFDF5E6)
            )
            Divider()
            TotalPrice()
            Divider()
            Price()
            Divider()
            RoundedButton(
                text = "Check Our",
                onClick = {
                }, modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 10.dp)
            )
        }
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun PreiviewTotalPrice(){
    ProductCart()
}


@Composable
fun TotalPrice() {
    Card(
        backgroundColor = Color(0xFFFFFFFF),
        modifier = Modifier.height(70.dp)
    ) {
        Box(
            Modifier
                .fillMaxSize()
        ) {
            RightComponent(modifier = Modifier
                .align(Alignment.TopStart)
                .padding(top = 10.dp, start = 20.dp, end = 10.dp))

            LeftComponent(modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 10.dp, start = 20.dp, end = 10.dp))
        }


    }

}

@Composable
fun RightComponent(modifier: Modifier) {
    Column(modifier) {
        TextComponent("Tiền hàng")
        Spacer(modifier = Modifier.height(10.dp))
        TextComponent("Phí Ship")
    }
}

@Composable
fun LeftComponent(modifier: Modifier) {
    Column(modifier) {
        TextComponent("370.000 đ")
        Spacer(modifier = Modifier.height(10.dp))
        TextComponent("Chưa tính")
    }
}



@Composable
fun Price(){
    Column(
        modifier = Modifier
            // with a height of 80 dp
            .height(50.dp)
            .padding(8.dp)
            .fillMaxWidth()
            .background(color = Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row {
            TextComponent("Thành tiền (3 sản phẩm) ")
            Spacer(modifier = Modifier.width(50.dp))
            TextComponent("370.000 đ")
        }
    }
}


@Composable
fun TextComponent(title: String) {
    Text(
        text = title,
        style = TextStyle(
            color = Color.Gray,
            fontSize = 16.sp
        ),
    )
}

@ExperimentalMaterialApi
@Composable
fun CartView() {
    val stateScrool = rememberScrollState()
    Column(
        modifier = Modifier
            .padding(8.dp)
            .verticalScroll(stateScrool)
    ) {
        InforOrder()
        Spacer(modifier = Modifier.height(10.dp))
        ProductCart()
    }
}

@Composable
fun InforOrder() {
    Column() {
        BoxComponentCart(
            icon = Icons.Default.Info,
            title = "Thông tin đơn hàng",
            content = "Mã đơn hàng là : 121100${Random.nextInt(1, 10)}",
            action = "Đang hoạt động ",
            onClick = {}
        )
        Box(
            Modifier
                .fillMaxSize()
                .height(30.dp)
        ) {
            Text("Thông tin này đã chính xác?", modifier = Modifier.align(Alignment.Center))
        }
        BoxComponentCart(
            icon = Icons.Default.Place,
            title = "Địa chỉ giao hàng",
            content = "Hoàng Trung Quan - +854123233423 - Thôn Phú Kinh -  Liên Trạch - Bố Trạch - Quảng Bình",
            action = "Thay đổi",
            onClick = {}
        )
    }

}


@ExperimentalMaterialApi
@Composable
fun Orders(
    text: String = "",
    image: Painter,
    price: Int = 0,
    backgroundColor: Color
) {

    ListItem(
        text = { Text(text = text, maxLines = 1) },
        secondaryText = {
            Text(text = "${price} VND", maxLines = 1)
        },
        icon = {
            Image(
                painter = image,
                contentDescription = "",
                modifier = Modifier
                    .height(80.dp)
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop
            )
        },
        trailing = {
            TextButton(
                onClick = {},
                modifier = Modifier
                    .padding(end = 1.dp)

            ) {
                Icon(
                    Icons.Filled.Close,
                    contentDescription = "Close",
                    tint = Color.Blue,
                    modifier = Modifier.padding(bottom = 30.dp)
                )
            }
        },
        modifier = Modifier.clickable {

        }
    )


}


@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun NotePreview() {
    Orders(
        text = "Đời sống",
        price = 123,
        image = painterResource(id = R.drawable.dich),
        backgroundColor = Color(0xffFEF4E7)
    )
}