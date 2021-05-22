package com.example.mvvmrecipeapp.presentation.ui.recipe_list

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
import dagger.hilt.android.AndroidEntryPoint
import org.w3c.dom.Text

@AndroidEntryPoint
class RecipeListFragment : Fragment() {

    private val viewModel : RecipeListViewModel by viewModels()

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

@Composable
fun RecipeList(
    findNavController: NavController,
    viewModel: RecipeListViewModel
) {

    val recipes = viewModel.recipes.value
    val searchInput = viewModel.query

    //Hide Keyboard
    val focusManager = LocalFocusManager.current

    Column{

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
                        value = searchInput.value,
                        placeholder = { Text(text = "Search recipe...") },
                        onValueChange =  { viewModel.onQueryChanged(it) },
                        label = { Text(text = "Search")},
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Search
                        ),
                        leadingIcon = {
                            Icon(Icons.Filled.Search, contentDescription = "Search")
                        },
                        keyboardActions = KeyboardActions(
                            onSearch = {
                                viewModel.newSearch(searchInput.value)
                                focusManager.clearFocus()
                            }
                        ),
                        textStyle = TextStyle(color = MaterialTheme.colors.primary),
                    )
                }
                Row {
                    for (category in getAllFoodCategories()) {
                        Text(
                            text = category.value,
                            style = MaterialTheme.typography.body2,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }

            }

        }

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