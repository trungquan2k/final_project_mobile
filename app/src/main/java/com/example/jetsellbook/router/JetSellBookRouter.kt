

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf


/**
 * Class defining the screens we have in the app.
 *
 * These objects should match files we have in the screens package
 */
sealed class Screen {
    object HomePage : Screen()
//    object LoginPage: Screen()
    object CartPage:Screen()
    object SearchPage: Screen()
}

object JetSellBookRouter {
    var currentScreen: MutableState<Screen> = mutableStateOf(Screen.HomePage)

    fun navigateTo(destination: Screen) {
        currentScreen.value = destination
    }
    private var previousScreen: MutableState<Screen> = mutableStateOf(
        Screen.HomePage
    )
}