package com.example.newsfeeds.presentation.component.menu

data class MenuItem(
    val id: MenuId,
    val title: String,
    val contentDescription: String,
    val icon: Int,
    var isSelected: Boolean = false
)


enum class MenuId {
    Explore,
    LiveChat,
    Gallery,
    WishList,
    Magazine
}