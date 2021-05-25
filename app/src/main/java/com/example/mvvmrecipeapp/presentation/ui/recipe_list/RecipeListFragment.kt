package com.example.mvvmrecipeapp.presentation.ui.recipe_list

import android.graphics.Camera
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.mvvmrecipeapp.R
import com.example.mvvmrecipeapp.presentation.components.CircularProgressBarIndicator
import com.example.mvvmrecipeapp.presentation.components.FoodCategoryChip
import com.example.mvvmrecipeapp.presentation.components.SearchAppBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeListFragment : Fragment() {

    private val viewModel : RecipeListViewModel by viewModels()

    @ExperimentalComposeApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val findNavController = findNavController()
                MaterialTheme {
                    RecipeList(
                        findNavController,
                        viewModel
                    )
                }
            }
        }
    }
}

@ExperimentalComposeApi
@Composable
fun RecipeList(
    findNavController: NavController,
    viewModel: RecipeListViewModel
) {

    val recipes = viewModel.recipes.value
    val searchInput = viewModel.query.value
    val selectedCategory = viewModel.selectedCategory.value



    Column{

        SearchAppBar(
            searchInput = searchInput,
            selectedCategory = selectedCategory,
            onQueryChanged = viewModel::onQueryChanged,
            onSelectedCategoryChanged = viewModel::onSelectedCategoryChanged,
            onExecuteSearch = viewModel::newSearch
        )

        CircularProgressBarIndicator(
            isDisplaying = viewModel.loading.value
        )
        //List of recipes
        LazyColumn(
            modifier = Modifier
                .padding(6.dp)
        ){
             itemsIndexed(
                 items = recipes
             ){ index, recipe ->
                 RecipeCard(
                     recipe = recipe,
                     onClick = {findNavController.navigate(R.id.viewRecipe)}
                     )
             }
        }

    }

}