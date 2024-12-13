package com.example.nearby.ui.screen.home

sealed class HomeUiEvent {
    data object OnFecthCategories: HomeUiEvent()
    data class OnFecthMarkets(val categoryId: String) : HomeUiEvent()
}