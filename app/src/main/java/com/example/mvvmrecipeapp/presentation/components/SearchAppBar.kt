package com.example.mvvmrecipeapp.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.mvvmrecipeapp.presentation.ui.recipe_list.FoodCategory
import com.example.mvvmrecipeapp.presentation.ui.recipe_list.getAllFoodCategories

@Composable
fun SearchAppBar(
    searchInput: String,
    onExecuteSearch : () -> Unit,
    selectedCategory: FoodCategory?,
    onQueryChanged: (String) -> Unit,
    onSelectedCategoryChanged: (String) -> Unit
){

    //Hide Keyboard
    val focusManager = LocalFocusManager.current

    //Search bar
    Surface (
        modifier = Modifier
            .fillMaxWidth(1f),
        color = MaterialTheme.colors.background,
        elevation = 8.dp
    ){
        Column {

            Row(
                modifier = Modifier
                    .fillMaxWidth(1f)
            ) {
                TextField(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(8.dp),
                    value = searchInput,
                    placeholder = { Text(text = "Search recipe...") },
                    onValueChange =  { onQueryChanged(it) },
                    label = { Text(text = "Search") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Search
                    ),
                    leadingIcon = {
                        Icon(Icons.Filled.Search, contentDescription = "Search")
                    },
                    keyboardActions = KeyboardActions(
                        onSearch = {
                            onExecuteSearch()
                            focusManager.clearFocus()
                        }
                    ),
                    textStyle = TextStyle(color = MaterialTheme.colors.primary),
                )
            }
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                for (category in getAllFoodCategories()) {
                    FoodCategoryChip(
                        category = category.value,
                        isSelected = selectedCategory == category ,
                        onSelectedCategoryChanged = {
                            onSelectedCategoryChanged(it)
                        },
                        onExecuteSearch = {
                            onExecuteSearch()
                        }
                    )
                }
            }

        }

    }
}