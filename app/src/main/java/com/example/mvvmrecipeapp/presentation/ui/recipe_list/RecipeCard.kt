package com.example.mvvmrecipeapp.presentation.ui.recipe_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.mvvmrecipeapp.domain.model.Recipe
import com.google.accompanist.glide.rememberGlidePainter

@Composable
fun RecipeCard(
    recipe :  Recipe,
    onClick : () -> Unit
) {
    Card (
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .padding(
                bottom = 10.dp,
                top = 6.dp
            )
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = 8.dp
    ){
        Column {
            recipe.featuredImage?.let { url ->
                Image(
                    painter = rememberGlidePainter(
                        request = url,
                        fadeIn = true
                    ),
                    contentDescription = "image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    contentScale = ContentScale.Crop
                )
            }
            recipe.title?.let { title ->
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)
                        ){
                        Text(
                            text = title,
                            modifier = Modifier
                                .fillMaxWidth(0.85f)
                                .wrapContentWidth(Alignment.Start),
                            style = MaterialTheme.typography.h5
                        )
                    Text(
                        text = recipe.rating.toString(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.End)
                            .align(Alignment.CenterVertically),
                        style = MaterialTheme.typography.h6
                        )
                }
            }
        }
    }
}


