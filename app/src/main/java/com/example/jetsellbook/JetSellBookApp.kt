package com.example.jetsellbook


import LoginScreen
import MyTopAppBar
import Screen
import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi

import androidx.compose.foundation.background

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color

import androidx.compose.ui.graphics.vector.ImageVector

import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp

import com.example.jetsellbook.appdrawer.AppDrawer
import com.example.jetsellbook.screen.CartScreen

import com.example.jetsellbook.screen.HomeScreen
//import com.example.jetsellbook.screen.LoginScreen
import com.example.jetsellbook.screen.SearchScreen
import com.example.jetsellbook.ui.theme.JetSellBookTheme

import com.example.jetsellbook.viewmodel.MainViewModel
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun JetBookWormApp(viewModel: MainViewModel) {
    if(viewModel.state.value.successLogin){
        JetSellBookTheme {
            AppContent(viewModel)
        }
    }else{
//        LoginScreen(viewModel)
        LoginScreen(viewModel)
    }
}


@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun AppContent(viewModel: MainViewModel) {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(Unit, block = {
        viewModel.getBookList()

    })

    Crossfade(targetState = JetSellBookRouter.currentScreen) { screenState ->
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                MyTopAppBar(
                    scaffoldState,
                    coroutineScope,
                )
            },
            drawerContent = {
                AppDrawer(
                    closeDrawerAction = {
                        coroutineScope.launch {
                            scaffoldState.drawerState.close()
                        }
                    }
                )
            },
            content = {
                MainScreenContainer(
                    screenState = screenState,
                    viewModel = viewModel,
                )

            },
            bottomBar = {
                BottomNavigationComponent(
                    modifier = Modifier.background(Color.Black),
                    screenState = screenState
                )
            },
            backgroundColor = Color(0xFFEAE9EE),
            drawerShape = RoundedCornerShape(bottomEnd = 50.dp)
        )
    }
}


@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
private fun MainScreenContainer(
    screenState: MutableState<Screen>,
    viewModel: MainViewModel,
) {
    when (screenState.value) {
        is Screen.HomePage -> HomeScreen(viewModel)
        is Screen.CartPage -> CartScreen(viewModel)
        is Screen.SearchPage -> SearchScreen(viewModel)
//        is Screen.LoginPage -> LoginScreen()
        else -> {}
    }
}

@Composable
private fun BottomNavigationComponent(
    modifier: Modifier = Modifier,
    screenState: MutableState<Screen>
) {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf(
        NavigationItem(0, R.drawable.ic_baseline_home_24, R.string.home, Screen.HomePage),
        NavigationItem(1, R.drawable.ic_search, R.string.search, Screen.SearchPage),
        NavigationItem(
            2,
            R.drawable.baseline_shopping_cart_24,
            R.string.cart,
            Screen.CartPage
        ),
        NavigationItem(3, R.drawable.ic_profile, R.string.profile, Screen.HomePage),
    )
    BottomNavigation(modifier = modifier, backgroundColor = (Color.LightGray)) {
        items.forEach {
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = it.vectorResourceId),
                        contentDescription = stringResource(id = it.contentDescriptionResourceId)
                    )
                },
                selected = selectedItem == it.index,
                onClick = {
                    selectedItem = it.index
                    screenState.value = it.screen
                },

                )
        }
    }
}


private data class NavigationItem(
    val index: Int,
    val vectorResourceId: Int,
    val contentDescriptionResourceId: Int,
    val screen: Screen,
)