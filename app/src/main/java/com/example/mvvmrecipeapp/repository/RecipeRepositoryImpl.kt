package com.example.mvvmrecipeapp.repository

import com.example.mvvmrecipeapp.domain.model.Recipe
import com.example.mvvmrecipeapp.network.model.RecipeDtoMapper
import com.example.mvvmrecipeapp.network.responses.RecipeService

class RecipeRepositoryImpl (
    private val recipeService: RecipeService,
    private val mapper: RecipeDtoMapper
        ): RecipeRepository {
    override suspend fun search(token: String, page: Int, query: String): List<Recipe> {
        val response = recipeService.search(
            token = token,
            page = page,
            query = query
        )

        return mapper.toDomainList(response.results)
    }

    override suspend fun get(token: String, id: Int): Recipe {
        val response = recipeService.get(
            token = token,
            id = id
        )

        return mapper.toDomainModel(response)
    }

}