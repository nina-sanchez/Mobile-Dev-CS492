package com.example.assignment4


import androidx.lifecycle.ViewModel
import com.example.assignment4.data.DataSource
import com.example.assignment4.model.Category
import com.example.assignment4.model.Recommendation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class TulumViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(TulumUiState())
    val uiState: StateFlow<TulumUiState> = _uiState

    fun setCategory(category: Category) {
        _uiState.value = _uiState.value.copy(
            currentCategory = category, // Now it sets the selected category
            recommendationList = category.recommendations,
            headerTitleId = category.name // Update title to match category name
        )
    }

    fun setRecommendation(recommendation: Recommendation) {
        _uiState.value = _uiState.value.copy(
            currentRecommendation = recommendation
        )
    }
}



data class TulumUiState(
    val categoryList: List<Category> = emptyList(),
    val recommendationList: List<Recommendation> = emptyList(),
    val currentCategory: Category? = null, // Add this line
    val currentRecommendation: Recommendation? = null,
    val headerTitleId: Int = R.string.app_name // Make sure this exists
)