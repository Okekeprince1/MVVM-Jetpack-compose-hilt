package com.example.mvvmrecipeapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController

class RecipeListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val findNavController = findNavController()
                MaterialTheme {
                    RecipeList(findNavController)
                }
            }
        }
    }
}

@Composable
fun RecipeList(
    findNavController: NavController
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text(text = "Recipe List Fragment")
        Spacer(modifier = Modifier.padding(10.dp))

        Button(
            onClick = {  findNavController.navigate(R.id.viewRecipe)}
        ) {
            Text(text = "Go To Recipe Fragment")
        }
    }
}