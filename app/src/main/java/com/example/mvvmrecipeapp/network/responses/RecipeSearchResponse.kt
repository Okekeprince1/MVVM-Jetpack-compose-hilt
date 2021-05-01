package com.example.mvvmrecipeapp.network.responses

import com.example.mvvmrecipeapp.network.model.RecipeDto
import java.util.*

data class RecipeSearchResponse(
    val count : Int? = null,
    val next: String? = null,
    val previous: String? = null,
    val results: List<RecipeDto>
)