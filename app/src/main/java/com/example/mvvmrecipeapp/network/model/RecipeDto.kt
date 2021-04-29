package com.example.mvvmrecipeapp.network.model


data class RecipeDto(
    val pk: Int? = null,
    val title: String? = null,
    val publisher: String? = null,
    val featured_image: String? = null,
    val rating: Int? = null,
    val source_url: String? = null,
    val description: String? = null,
    val cooking_instructions: String? = null,
    val ingredients: List<String>? = null,
    val date_added: String? = null,
    val date_updated: String? = null,
    val long_date_added: Int? = null,
    val long_date_updated: Int? = null
)