



import androidx.compose.foundation.background

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Preview(showBackground = true)
@Composable
fun TopAppBarPreviwe(){
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    MyTopAppBar(scaffoldState = scaffoldState, scope =coroutineScope )
}


@Composable
fun MyTopAppBar(scaffoldState: ScaffoldState, scope: CoroutineScope) {
    val drawerState = scaffoldState.drawerState
    val backgroundColor = remember {
        mutableStateOf(Color(0xFF00FFFF))
    }
    MaterialTheme {
        Column {
            TopAppBar(
                title = { Text(text = "Search Books") },
                backgroundColor = Color(0xFF99CC00),
                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch {
                            if (drawerState.isClosed) drawerState.open() else drawerState.close()
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Menu"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {  }) {
                        Icon(
                            imageVector = Icons.Filled.AccountCircle,
                            contentDescription = "Account"
                        )
                    }
                },
                elevation = 0.dp
            )

        }
    }
}
@Composable
fun RoundedCornerShapes(
) {
    Column(
        modifier = Modifier
            .height(50.dp)
            .graphicsLayer {
                shape = RoundedCornerShape(
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
                clip = true
            }
            .fillMaxSize()
            .background(Color(0xFF99CC00))
    ){

    }
}

@Preview
@Composable
fun RoundedCornerShapePreView(){
    RoundedCornerShapes()
}