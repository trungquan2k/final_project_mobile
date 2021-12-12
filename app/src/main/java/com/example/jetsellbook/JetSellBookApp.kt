package com.example.jetsellbook


import MyTopAppBar
import RoundedCornerShapes
import Screen
import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp

import com.example.jetsellbook.appdrawer.AppDrawer
import com.example.jetsellbook.components.ShadowComponent
import com.example.jetsellbook.screen.CartScreen

import com.example.jetsellbook.screen.HomeScreen
import com.example.jetsellbook.screen.SearchScreen
import com.example.jetsellbook.ui.theme.JetSellBookTheme
import com.example.jetsellbook.viewmodel.MainViewModel
import kotlinx.coroutines.launch

@ExperimentalAnimationApi
@Composable
fun JetBookWormApp(viewModel: MainViewModel) {
    JetSellBookTheme {
        AppContent(viewModel)
    }
}


@ExperimentalAnimationApi
@Composable
fun AppContent(viewModel: MainViewModel) {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val scrollState = rememberScrollState()
    val fabShape = RoundedCornerShape(50)

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
            isFloatingActionButtonDocked = true,
            floatingActionButtonPosition = FabPosition.Center,
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    text = {
                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = "Random Book"
                        )
                    },
                    shape = fabShape,
                    onClick = {

                    }
                )
            },
            content = {
                RoundedCornerShapes()
                ShadowComponent()
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
            backgroundColor = Color(0xFFFFFFFF),
            drawerShape = RoundedCornerShape(bottomEnd = 50.dp)
        )
    }
}


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
        NavigationItem(
            1,
            R.drawable.ic_baseline_format_list_bulleted_24,
            R.string.menu,
            Screen.CartPage
        ),
        NavigationItem(2, R.drawable.ic_baseline_add_24, R.string.profile, Screen.SearchPage),
        NavigationItem(3, R.drawable.ic_launcher_foreground, R.string.profile, Screen.LoginPage),
    )
    BottomNavigation(modifier = modifier) {
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