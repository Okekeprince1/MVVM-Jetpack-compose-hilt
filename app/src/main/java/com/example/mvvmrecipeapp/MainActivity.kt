package com.example.mvvmrecipeapp

import android.graphics.Bitmap
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mvvmrecipeapp.ui.theme.MVVMRecipeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVVMRecipeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Column (
        modifier = Modifier.fillMaxSize()
            .background(
                color = Color(0xFFF2F2F2)
            )
    ){
        val typography = MaterialTheme.typography
        Image(
            painter = painterResource(id = R.drawable.happy_meal),
            contentDescription = "Happy meal",
            modifier = Modifier.height(300.dp),
            contentScale = ContentScale.Crop
            )
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "French Fries",
                style = typography.h5
                )
            Spacer(modifier = Modifier.padding(top = 8.dp))
            Text(text = "200 Calories",
                style = typography.h6)
            Spacer(modifier = Modifier.padding(top = 8.dp))
            Text(text = "$ 80",
                color = Color.Green,
                style = typography.h6)
        }
    }

}

@Preview(showBackground = true, apiLevel = 10, showSystemUi = true)
@Composable
fun DefaultPreview() {
    MVVMRecipeAppTheme {
        Greeting()
    }
}