package com.example.jetsellbook.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import com.example.jetsellbook.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp




@Composable
fun ShadowComponent() {
    Column(
        modifier = Modifier
            // with a height of 250 dp
            .height(80.dp)
            // and a padding of 16 dp
            .padding(top = 20.dp, start = 16.dp, end = 16.dp)
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(8.dp)
            )
            .background(color = Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painterResource(id = R.drawable.camera_icon),
                contentDescription = "",
                modifier = Modifier
                    .size(50.dp)
                    .fillMaxWidth()
            )
            Divider(
                color = Color.Red,
                modifier = Modifier
                    .height(38.dp)
                    .width(1.dp)
                    .padding(top = 8.dp)
            )
            TitleComponent("Hoang Trung Quan")
            IconButton(
                onClick = {}
            ){
                Icon(
                    imageVector = Icons.Filled.LocationOn,
                    contentDescription = "Menu",
                    modifier=Modifier.background(Color.Black)
                )
            }
        }

    }
}

@Composable
fun TitleComponent(text:String ) {
    Text(
        text,
        style = TextStyle(
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.W900,
            fontSize = 14.sp, color = Color.Black
        ), modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
    )
}

