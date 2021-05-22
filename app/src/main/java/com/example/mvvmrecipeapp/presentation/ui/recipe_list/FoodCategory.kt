package com.example.mvvmrecipeapp.presentation.ui.recipe_list

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

//fun getFoodCategory(value: String) : FoodCategory?{
//
//    val map = getAllFoodCategories().
//    //val map = FoodCategory.values().(FoodCategory::value)
//    return map[value]
//}