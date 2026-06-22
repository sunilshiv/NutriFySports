package com.nutrifysports.home.domain

import com.nutrifysports.shared.Resources
import com.nutrifysports.shared.domain.navigation.Screen
import org.jetbrains.compose.resources.DrawableResource

enum class BottomBarNavigation(
    val icon: DrawableResource,
    val title: String,
    val screen: Screen
) {
    ProductOverview(
        icon = Resources.Image.Home,
        title = "NutriFySports",
        screen = Screen.HomeGraph
    ),

    Cart(
        icon = Resources.Icon.ShoppingCart,
        title = "Cart",
        screen = Screen.Cart
    ),

    Categories(
        icon = Resources.Image.Categories,
        title = "Categories",
        screen = Screen.Categories
    )


}