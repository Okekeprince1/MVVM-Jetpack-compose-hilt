package com.example.mvvmrecipeapp.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
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
    isSelected: Boolean = false,
    onSelectedCategoryChanged: (String) -> Unit,
    onExecuteSearch: () -> Unit
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        elevation = 8.dp,
        color = if (isSelected) Color.LightGray else MaterialTheme.colors.secondary,
        modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Row(
                modifier = Modifier.toggleable(
                    value = isSelected,
                    onValueChange = {
                        onSelectedCategoryChanged(category)
                        onExecuteSearch()
                    }
                ),
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