package com.mrmisti.copilot.deck

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.mvikotlin.extensions.coroutines.states
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import com.example.pruebatheming.designsystem.theme.CopilotDeckTheme
import com.example.pruebatheming.presentation.home.HomeScreen
import com.example.pruebatheming.presentation.home.HomeStoreFactory
import com.example.pruebatheming.presentation.home.HomeViewState

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
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    HomeScreen(homeStore)
                }
            }
        }
    }
}
