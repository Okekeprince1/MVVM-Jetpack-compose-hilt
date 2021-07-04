package com.example.mvvmrecipeapp.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.mvvmrecipeapp.ui.theme.MVVMRecipeAppTheme

@ExperimentalComposeApi
@Composable
fun CircularProgressBarIndicator(
    isDisplaying : Boolean
){
    if (isDisplaying){
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
        ) {
            val (text, progressBar) = createRefs()

            CircularProgressIndicator(
                modifier = Modifier.constrainAs(progressBar) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                },
                color = MaterialTheme.colors.primary
            )

            Text(text = "Loading...",
                style = TextStyle(
                    color = Color.DarkGray,
                    //fontSize = TextUnit(value = 8f, type = TextUnitType.Sp)
                ),
                modifier = Modifier
                    .constrainAs(text) {
                        top.linkTo(progressBar.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }
            )
        }
    }
}




