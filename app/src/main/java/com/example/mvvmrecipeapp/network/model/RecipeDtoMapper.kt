package com.example.mvvmrecipeapp.network.model

import com.example.mvvmrecipeapp.domain.model.Recipe
import com.example.mvvmrecipeapp.domain.util.DomainMapper
import java.util.*


class RecipeDtoMapper : DomainMapper<RecipeDto, Recipe> {
    override fun toDomainModel(model: RecipeDto): Recipe {
        return Recipe(
             id = model.pk,
             title = model.title,
             publisher = model.publisher,
             featuredImage = model.featured_image,
             rating = model.rating,
             sourceUrl = model.source_url,
             description = model.description,
             cookingInstructions = model.cooking_instructions,
             ingredients = model.ingredients?: listOf(),
             dateAdded = model.date_added,
             dateUpdated = model.date_updated,
             longDateAdded = model.long_date_added,
             longDateUpdated = model.long_date_updated,
        )
    }

    override fun fromDomainModel(model: Recipe): RecipeDto {
        return RecipeDto(
            pk = model.id,
            title = model.title,
            publisher = model.publisher,
            featured_image = model.featuredImage,
            rating = model.rating,
            source_url = model.sourceUrl,
            description = model.description,
            cooking_instructions = model.cookingInstructions,
            ingredients = model.ingredients,
            date_added = model.dateAdded,
            date_updated = model.dateUpdated,
            long_date_added = model.longDateAdded,
            long_date_updated = model.longDateUpdated
        )
    }

    fun toDomainList(initial: List<RecipeDto>): List<Recipe> {
        return initial.map {
            toDomainModel(it)
        }
    }

    fun fromDomainList(initial: List<Recipe>) : List<RecipeDto> {
        return initial.map {
            fromDomainModel(it)
        }
    }

}