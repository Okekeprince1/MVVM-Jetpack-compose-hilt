package com.example.mvvmrecipeapp.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun FoodCategoryChip(
    category: String,
    onExecuteSearch: (String) -> Unit
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        elevation = 8.dp,
        color = MaterialTheme.colors.secondary,
        modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Row(
                modifier = Modifier.clickable {
                    onExecuteSearch(category)
                },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = category,
                    modifier = Modifier.padding(8.dp),
                    color = Color.White,
                    style = MaterialTheme.typography.body2,
                )
            }
    }
}