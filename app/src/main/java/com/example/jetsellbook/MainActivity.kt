package com.example.jetsellbook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.SideEffect

import com.example.jetsellbook.ui.theme.JetSellBookTheme
import com.example.jetsellbook.viewmodel.MainViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController


class MainActivity : ComponentActivity() {

    @ExperimentalMaterialApi
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: MainViewModel by viewModels()
        setContent {
            val systemUiController = rememberSystemUiController()
            val useDarkIcons = MaterialTheme.colors.isLight
            val systemBarColor = MaterialTheme.colors.surface

            SideEffect {
                systemUiController.setSystemBarsColor(
                    color = systemBarColor,
                    darkIcons = useDarkIcons
                )
            }
            JetSellBookTheme() {
                Surface(color = MaterialTheme.colors.background) {
                    JetBookWormApp(viewModel)
                }
            }

        }
    }
}

