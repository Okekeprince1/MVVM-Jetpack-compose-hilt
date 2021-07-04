package com.example.mvvmrecipeapp.presentation.ui.recipe_list

import android.util.Log

enum class FoodCategory(val value: String){
    CHICKEN("Chicken"),
    BEEF("Beef"),
    SOUP("Soup"),
    VEGETARIAN("Vegetarian"),
    DESSERT("Dessert"),
    MILK("Milk"),
    PIZZA("Pizza"),
    DONUT("Donut"),
    BREAD("Bread")
}

fun getAllFoodCategories() : List<FoodCategory> {
    return listOf(
        FoodCategory.CHICKEN,
        FoodCategory.BEEF,
        FoodCategory.SOUP,
        FoodCategory.VEGETARIAN,
        FoodCategory.DESSERT,
        FoodCategory.MILK,
        FoodCategory.PIZZA,
        FoodCategory.DONUT,
        FoodCategory.BREAD
    )
}

fun getFoodCategory(value: String) : FoodCategory?{


    val foodCategoriesMap = hashMapOf<String, FoodCategory>()

    for (keys in getAllFoodCategories()){
        foodCategoriesMap[keys.value] = keys
    }
    return foodCategoriesMap[value]
}