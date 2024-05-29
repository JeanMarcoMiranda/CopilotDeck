package com.mrmisti.copilot.deck

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.arkivanov.mvikotlin.extensions.coroutines.states
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import com.example.pruebatheming.designsystem.theme.CopilotDeckTheme
import com.example.pruebatheming.presentation.home.HomeStoreFactory
import com.example.pruebatheming.presentation.home.HomeViewState
import com.mrmisti.copilot.deck.presentation.card.CardScreen
import com.mrmisti.copilot.deck.presentation.map.MapScreen
import com.mrmisti.copilot.deck.presentation.message.MessageScreen
import com.mrmisti.copilot.deck.presentation.settings.SettingsScreen
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    private val homeStore = HomeStoreFactory(DefaultStoreFactory()).create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val homeState by homeStore.states.collectAsState(initial = HomeViewState())

            CopilotDeckTheme(
                theme = homeState.selectedTheme,
                darkTheme = homeState.isDarkTheme,
            ) {
                val navController = rememberNavController()
                var currentRoute by remember {
                    mutableStateOf<Screen>(Screen.Card)
                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        BerlinSidebar(
                            currentRoute = currentRoute,
                            onItemClick = { route ->
                                currentRoute = route
                                navController.navigate(route)
                                val route = navController.currentBackStackEntry?.destination?.route
                                Log.i("Current Route", "El valor es $route")
                            },
                        )
                        NavHost(
                            navController = navController,
                            startDestination = Screen.Card,
                        ) {
                            composable<Screen.Card> {
                                CardScreen()
                            }
                            composable<Screen.Map> {
                                MapScreen()
                            }
                            composable<Screen.Mesage> {
                                MessageScreen()
                            }
                            composable<Screen.Settings> {
                                SettingsScreen()
                            }
                        }
                    }
                }
            }
        }
    }
}

sealed interface Screen {
    @Serializable
    data object Card : Screen

    @Serializable
    data object Map : Screen

    @Serializable
    data object Mesage : Screen

    @Serializable
    data object Settings : Screen
}
