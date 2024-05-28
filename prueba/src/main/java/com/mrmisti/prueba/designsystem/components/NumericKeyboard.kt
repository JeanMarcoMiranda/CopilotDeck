package com.mrmisti.prueba.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NumericKeyboard(
    onNumberClick: (Int) -> Unit,
    onBackspaceClick: () -> Unit
) {
    val numbers = listOf(
        listOf(1, 2, 3),
        listOf(4, 5, 6),
        listOf(7, 8, 9),
        listOf(-1, 0, -2)
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
       numbers.forEach { row ->
           Row(
               modifier = Modifier
                   .fillMaxWidth(),
               horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
           ) {
               row.forEach { number ->
                   Box(
                       modifier = Modifier
                           .size(64.dp)
                           .background(
                               color = if (number >= 0) MaterialTheme.colorScheme.primary else Color.Transparent,
                               shape = MaterialTheme.shapes.medium
                           )
                           .clickable {
                               when (number) {
                                   in 0..9 -> onNumberClick(number)
                                   -2 -> onBackspaceClick()
                               }
                           },
                       contentAlignment = Alignment.Center
                   ) {
                       if (number >= 0) {
                           Text(
                               text = number.toString(),
                               fontSize = 24.sp,
                               color = Color.White
                           )
                       } else if (number == -2) {
                           Text(
                               text = "⌫",
                               fontSize = 24.sp,
                           )
                       }
                   }
               }
           }
       }
    }
}