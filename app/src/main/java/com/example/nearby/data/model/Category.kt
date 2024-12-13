package com.example.nearby.data.model

import androidx.annotation.DrawableRes
import com.example.nearby.ui.component.category.CategoryFilterChipView
import kotlinx.serialization.Serializable

@Serializable
data class Category(
    val id: String,
    val name: String,
) {
    @get:DrawableRes
    val icon: Int?
        get() = CategoryFilterChipView.fromDescription(description = name)?.icon
}