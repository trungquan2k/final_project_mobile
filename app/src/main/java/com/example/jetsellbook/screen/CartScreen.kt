package com.example.jetsellbook.screen

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import com.example.jetsellbook.components.CartView
import com.example.jetsellbook.viewmodel.MainViewModel

@ExperimentalMaterialApi
@Composable
fun CartScreen(viewModel: MainViewModel){
    CartView()
}

