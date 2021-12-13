package com.example.jetsellbook.screen

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetsellbook.R

import com.example.jetsellbook.viewmodel.MainViewModel



@Composable
fun ProfileScreen(viewModel: MainViewModel) {
    Header(viewModel)
}



@Composable
fun Header(viewModel: MainViewModel) {
    Card(
        backgroundColor = Color(0xFFFFFFFF),
    ) {
        Box(
            Modifier.fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
            )
            {
                Text(
                    viewModel.emails,
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 16.sp
                    ),
                )
                RoundImage(
                    image = painterResource(id = R.drawable.tinh_cam),
                    modifier = Modifier
                        .size(100.dp)
                )
                Text(
                    "Tham gia cùng chúng tôi 2021",
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 16.sp
                    )
                )
                Divider()
                ComponentEdit("Thông tin cơ bản", Icons.Default.Edit)
                ComponentInfo(Icons.Default.Person, "Hoàng Trung Quan ")
                ComponentInfo(Icons.Default.Email,viewModel.emails)
                ComponentInfo(icon = Icons.Default.Phone, title = "(+84)0355784915")

                Spacer(modifier=Modifier.height(5.dp))
                //Change Password
                ComponentEdit("Chỉnh sửa mật khẩu", Icons.Default.Edit)
                ComponentInfo(Icons.Default.Lock, "Nhập mật khẩu mới")
                ComponentInfo(icon = Icons.Default.Lock, title = "Nhập lại mật khẩu mới")

                Spacer(modifier=Modifier.height(5.dp))
                //About us
                ComponentEdit("Thông tin của chúng tôi", Icons.Default.Info)
                ComponentInfo(Icons.Default.Info, "Nhà sản xuất")
                ComponentInfo(icon = Icons.Default.Lock, title = "Điều khoản và dịch vụ")

            }

        }
    }
}


@Composable
fun ComponentEdit(
    title: String,
    icon: ImageVector
) {
    Row(modifier = Modifier
        .padding(8.dp)
        .height(30.dp)) {
        Text(
            text = title,
            style = TextStyle(
                color = Color.Blue, fontSize = 16.sp,
            ),
            modifier=Modifier.weight(1f)
        )
       Icon(
            imageVector = icon,
           contentDescription = ""
       )
    }
}


@Composable
fun ComponentInfo(
    icon: ImageVector,
    title: String
){
    Box(modifier = Modifier.fillMaxWidth()){
        TextButton(
            onClick = {
                // do something here
            }
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "Icon",
                modifier = Modifier.padding(end = 8.dp),
                tint = Color(0xFFCC3333)
            )
            Text(text = title)
        }
    }
    Divider()
}


@Composable
fun RoundImage(
    image: Painter,
    modifier: Modifier = Modifier
) {
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape)
    )
}
