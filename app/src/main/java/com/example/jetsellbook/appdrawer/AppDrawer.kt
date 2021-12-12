package com.example.jetsellbook.appdrawer


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetsellbook.R

import kotlinx.coroutines.launch

@Composable
fun AppDrawer(closeDrawerAction: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .background(color = MaterialTheme.colors.surface)
    ) {
        AppDrawerHeader(closeDrawerAction)
        AppDrawerBody(closeDrawerAction)

//        AppDrawerFooter(modifier)
    }
}



@Composable
fun AppDrawerHeader(closeDrawerAction:()->Unit){
    Column() {
        Row(modifier = Modifier.padding(10.dp)) {
            Box(modifier = Modifier.fillMaxWidth().weight(10f).align(Alignment.CenterVertically))
            Box(modifier = Modifier.fillMaxWidth().weight(1f).align(Alignment.CenterVertically)){
                Icon(
                    Icons.Default.Close,
                    contentDescription = "Close",
                    modifier = Modifier.clickable { closeDrawerAction() }
                )
            }
        }
        Image(
            painter = painterResource(id = R.drawable.sachlogo),
            contentDescription="",
            modifier=Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))

    }
    Divider(
        color = MaterialTheme.colors.onSurface.copy(alpha = .2f),
        modifier = Modifier.padding(
            start = 16.dp,
            end = 16.dp,
            top = 16.dp
        )
    )
}


@Composable
fun AppDrawerBody(closeDrawerAction: () -> Unit){
    val scope = rememberCoroutineScope()
    val result = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .background(Color(0xFFFFFAF0))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(75.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "APP Title",
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                textAlign = TextAlign.Center
            )
        }

        Column(
            modifier = Modifier
        ) {
            Row(modifier = Modifier
                .clickable {
                    scope.launch {
                        closeDrawerAction()
                        result.value = "Refresh clicked"
                    }
                }
                .fillMaxWidth()
                .padding(8.dp)
                .padding(start = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(Icons.Filled.Home, contentDescription = "")
                Text(
                    text = "Home",
                    fontWeight = FontWeight.Bold
                )
            }

            Row(modifier = Modifier
                .clickable {
                    scope.launch {
                        closeDrawerAction()
                        result.value = "Cloud upload clicked"
                    }
                }
                .fillMaxWidth()
                .padding(8.dp)
                .padding(start = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(Icons.Filled.Email, contentDescription = "")
                Text(
                    text = "Email",
                    fontWeight = FontWeight.Bold
                )
            }

            Row(modifier = Modifier
                .clickable {
                    scope.launch {
                        closeDrawerAction()
                        result.value = "Search clicked"
                    }
                }
                .fillMaxWidth()
                .padding(8.dp)
                .padding(start = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(Icons.Filled.Search, contentDescription = "")
                Text(
                    text = "Search",
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}