package com.example.mvvmrecipeapp.presentation.ui.recipe_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmrecipeapp.domain.model.Recipe
import com.example.mvvmrecipeapp.network.model.RecipeDtoMapper
import com.example.mvvmrecipeapp.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
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

    val selectedCategory : MutableState<FoodCategory?> = mutableStateOf(null)

    val loading: MutableState<Boolean> = mutableStateOf(false)

    init {
        newSearch()
    }

    fun onQueryChanged(value: String){
        query.value = value
    }

    fun newSearch() {
        viewModelScope.launch {
            loading.value = true

            resetSearchState()

            delay(2000)

            val result = repository.search(
                token = token,
                page = 1,
                query = query.value
            )

            recipes.value = result
            loading.value = false
        }
    }

    fun onSelectedCategoryChanged(category: String) {
        val newCategory = getFoodCategory(category)
        selectedCategory.value = newCategory
        onQueryChanged(category)
    }

    private fun resetSearchState(){
        recipes.value = listOf()
        if(selectedCategory.value?.value != query.value){
            clearCategorySelected()
        }
    }

    private fun clearCategorySelected() {
        selectedCategory.value = null
    }

}