package com.example.pruebatheming.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.arkivanov.mvikotlin.extensions.coroutines.states
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pruebatheming.designsystem.theme.AppTheme

@Composable
fun HomeScreen(homeStore: HomeStore) {
    val homeState by homeStore.states.collectAsState(initial = HomeViewState())
    val themes = listOf("Berlin", "Jacket")

    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column {
            Text(
                text = "Select Theme:",
            )

            Box {
                Button(
                    onClick = { homeStore.accept(HomeIntent.ToggleSelect)},
                ) {
                    Text(text = themes[homeState.selectedTheme.ordinal])
                    Icon(
                        imageVector = Icons.Filled.ArrowDropDown,
                        contentDescription = null
                    )
                }
                DropdownMenu(
                    expanded = homeState.selectExpanded,
                    onDismissRequest = {
                        homeStore.accept(HomeIntent.ToggleSelect)
                    }
                ) {
                    themes.forEachIndexed { index, theme ->
                        DropdownMenuItem(
                            text = { Text(text = theme) },
                            onClick = {
                                homeStore.accept(HomeIntent.OnSelectTheme(AppTheme.values()[index]))
                                homeStore.accept(HomeIntent.ToggleSelect)
                            }
                        )
                    }
                }
            }
        }


        Spacer(modifier = Modifier.width(16.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Dark Theme:")
            Switch(
                checked = homeState.isDarkTheme,
                onCheckedChange = { homeStore.accept(HomeIntent.ToggleDarkTheme) }
            )
        }
    }
}