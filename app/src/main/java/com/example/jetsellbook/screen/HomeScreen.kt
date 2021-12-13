package com.example.jetsellbook.screen



import android.widget.Toast
import androidx.compose.animation.ExperimentalAnimationApi

import androidx.compose.foundation.layout.*

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.unit.dp
import com.example.jetsellbook.components.ScrollEffectPager
import com.example.jetsellbook.viewmodel.MainViewModel
import com.example.jetsellbook.R
import com.example.jetsellbook.components.BookCategories



@ExperimentalAnimationApi
@Composable
fun HomeScreen(viewModel: MainViewModel) {
    val scrollState = rememberScrollState()
    LaunchedEffect(Unit, block = {
        viewModel.getBookList()
    })
    if (viewModel.errorMessage.isEmpty()) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .verticalScroll(scrollState)
        ) {
            ScrollEffectPager()
            New_Trend(viewModel = viewModel)
            CategorySection()
            ListBookScreen(viewModel = viewModel)
        }
    } else {
        Text(viewModel.errorMessage)
    }

}

@Composable
fun CategorySection() {
    val context= LocalContext.current
    Column(Modifier.padding(horizontal = 16.dp)) {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Category", style = MaterialTheme.typography.h6)
            TextButton(
                onClick = {
                    Toast.makeText(context, "Chức năng đang được hoàn thiện", Toast.LENGTH_SHORT).show()
                }
            ) {
                Text(
                    text = "Xem tất cả",
                    color = MaterialTheme.colors.primary,

                )
            }
        }
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            BookCategories(
                text = "Đời sống",
                image = painterResource(id = R.drawable.dich),
                backgroundColor = Color(0xffFEF4E7)
            )
            BookCategories(
                text = "Kỷ năng",
                image = painterResource(id = R.drawable.dac_nhan_tam),
                backgroundColor = Color(0xffFEF4E7)
            )
            BookCategories(
                text = "Tinh Cam",
                image = painterResource(id = R.drawable.tinh_cam),
                backgroundColor = Color(0xffFEF4E7)
            )
            BookCategories(
                text = "Gia đình",
                image = painterResource(id = R.drawable.phunu),
                backgroundColor = Color(0xffFEF4E7)
            )
        }
    }
}

