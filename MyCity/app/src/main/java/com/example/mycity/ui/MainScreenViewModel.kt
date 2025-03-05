// Regina Sanchez
// OSU
// CS 492

package com.example.mycity.ui

import com.example.mycity.model.Categories
import com.example.mycity.model.Recommendations
import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import com.example.mycity.R
import com.example.mycity.data.DataSource
import com.example.mycity.data.DataNav
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class MainScreenViewModel : ViewModel() {
    private val _state = MutableStateFlow(DataNav(categoryList = DataSource.getCategories()))
    val state: StateFlow<DataNav> = _state.asStateFlow()
    fun setCategory(firstSelection: Categories) {
        _state.update {
            it.copy(
                currentCategory = firstSelection,
                headerTitleId = firstSelection.name
            )
        }
        nextList(firstSelection.name)
    }
    fun setRecommendation(selectedRecommendation: Recommendations) {
        _state.update {
            it.copy(currentRecommendation = selectedRecommendation)
        }
    }
    private fun nextList(@StringRes categoryTitleId: Int) {
        val recommendationList: List<Recommendations> = when (categoryTitleId) {
            R.string.category_1 -> DataSource.getBeachClubs()
            R.string.category_2 -> DataSource.getRestaurants()
            R.string.category_3 -> DataSource.getCenotes()
            else -> DataSource.getBeachClubs()
        }
        _state.update {
            it.copy(recommendationList = recommendationList)
        }
    }
}
