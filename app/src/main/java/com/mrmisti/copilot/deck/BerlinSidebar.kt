package com.mrmisti.copilot.deck

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ForwardToInbox
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.TravelExplore
import androidx.compose.material.icons.outlined.ViewDay
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun BerlinSidebar(
    currentRoute: Screen,
    onItemClick: (route: Screen) -> Unit,
) {
    val items =
        listOf(
            BerlinSidebarItem(Screen.Card, stringResource(id = R.string.text_sidebar_card), Icons.Outlined.ViewDay),
            BerlinSidebarItem(Screen.Map, stringResource(id = R.string.text_sidebar_map), Icons.Outlined.TravelExplore),
            BerlinSidebarItem(Screen.Mesage, stringResource(id = R.string.text_sidebar_message), Icons.Outlined.ForwardToInbox),
            BerlinSidebarItem(Screen.About, stringResource(id = R.string.text_sidebar_about), Icons.Outlined.Info),
            BerlinSidebarItem(Screen.Settings, stringResource(id = R.string.text_sidebar_settings), Icons.Outlined.Settings),
        )

    Column(
        modifier =
            Modifier
                .fillMaxHeight()
                .width(80.dp)
                .padding(bottom = 15.dp),
    ) {
        items.forEach { item ->
            BerlinSidebarItemView(
                item = item,
                isSelected = currentRoute == item.route,
                modifier = Modifier.weight(1f),
                onClick = { onItemClick(item.route) },
            )
        }
    }
}
