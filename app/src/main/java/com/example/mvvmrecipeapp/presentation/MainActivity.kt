package com.example.mvvmrecipeapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity
import com.example.mvvmrecipeapp.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

















//        val service = Retrofit.Builder()
//            .baseUrl("https://food2fork.ca/api/recipe/")
//            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
//            .build()
//            .create(RecipeService::class.java)
//
//        CoroutineScope(IO).launch {
//            val response = service.get(
//                token = "Token 9c8b06d329136da358c2d00e76946b0111ce2c48",
//                id = 584
//            )
//
//            Log.i("MAIN ACTIVITY", "onCreate ${response.publisher}")
//        }


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

