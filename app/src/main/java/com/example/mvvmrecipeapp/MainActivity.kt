package com.example.mvvmrecipeapp

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.NavHostFragment
import com.example.mvvmrecipeapp.ui.theme.MVVMRecipeAppTheme

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

//@Composable
//fun Greeting() {
//    Column (
//        modifier = Modifier
//            .fillMaxSize()
//            .background(
//                color = Color(0xFFF2F2F2)
//            )
//    ){
//        val typography = MaterialTheme.typography
//        Image(
//            painter = painterResource(id = R.drawable.happy_meal),
//            contentDescription = "Happy meal",
//            modifier = Modifier.height(300.dp),
//            contentScale = ContentScale.Crop,
//            )
//        Column(
//            modifier = Modifier.padding(16.dp)
//        ) {
//            Row(
//                horizontalArrangement = Arrangement.SpaceBetween,
//                modifier = Modifier.fillMaxWidth()
//            ){
//                Text(
//                    text = "French Fries",
//                    style = typography.h5,
//                )
//                Text(text = "$ 80",
//                    color = Color(0xFFA1FA39),
//                    style = typography.h6,
//                    modifier = Modifier.align(Alignment.CenterVertically)
//                )
//            }
//            Spacer(modifier = Modifier.padding(top = 8.dp))
//            Text(text = "200 Calories",
//                style = typography.h6,
//                color = Color(0xFF5F5F5F))
//            Button(
//                onClick = { /*TODO*/ },
//                modifier = Modifier
//                    .align(Alignment.CenterHorizontally)
//                    .background(color = Color(0xFFFCF3E70))
//            ) {
//                Text(stringResource(id = R.string.order_now))
//            }
//        }
//    }
//
//}
//
//@Preview(showBackground = true, apiLevel = 10, showSystemUi = true)
//@Composable
//fun DefaultPreview() {
//    MVVMRecipeAppTheme {
//        Greeting()
//    }
//}

