package com.example.jetsellbook.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon

import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info


import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetsellbook.R

@Preview
@Composable
fun PreviewBoxComponentCart(

){
    BoxComponentCart(
        icon = Icons.Default.Info,
        title = "Hoang Trung Quan",
        content = "hihiádasdasd",
        action = "Thay đổi",
        onClick = {}
        )
}


@Composable
fun BoxComponentCart(
    icon: ImageVector,
    title: String,
    content: String,
    action: String,
    onClick: ()->Unit
) {
    Card(
        shape = RoundedCornerShape(4.dp),
        backgroundColor = Color(0xffFEF4E7)
    ){
        Row(
            modifier= Modifier
                .padding(
                    start = 8.dp,
                    end = 8.dp,
                    top = 12.dp,
                    bottom = 8.dp
                )
                .fillMaxWidth()
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "",
                tint = Color.Unspecified,
                modifier=Modifier.size(20.dp).padding(top = 3.dp)
            )
            Spacer(modifier = Modifier.width(5.dp))
            Column(modifier=Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 15.sp
                    ),

                    )
                Spacer(modifier = Modifier.width(40.dp))
                Text(
                    text = content,
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 13.sp
                    ),
                )
            }
            TextButton(
                onClick = {onClick}
            ){
                Text(text = action)
            }
        }
    }

}