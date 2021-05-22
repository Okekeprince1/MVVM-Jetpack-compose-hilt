package com.example.mvvmrecipeapp.presentation.ui.recipe_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmrecipeapp.domain.model.Recipe
import com.example.mvvmrecipeapp.network.model.RecipeDtoMapper
import com.example.mvvmrecipeapp.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class RecipeListViewModel @Inject constructor(
    private val repository: RecipeRepository,
     @Named("auth_token") private val token : String
) : ViewModel() {

    val recipes : MutableState<List<Recipe>> = mutableStateOf(listOf())

    val query : MutableState<String> = mutableStateOf("")

    init {
        newSearch("Chicken")
    }

    fun onQueryChanged(value: String){
        query.value = value
    }

    fun newSearch(query : String) {
        viewModelScope.launch {
            val result = repository.search(
                token = token,
                page = 1,
                query = query
            )

            recipes.value = result
        }
    }



}