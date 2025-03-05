package com.example.mycity.data

import com.example.mycity.R
import androidx.annotation.StringRes
import com.example.mycity.model.Categories
import com.example.mycity.model.Recommendations

data class DataNav(
    @StringRes val headerTitleId: Int = R.string.app_name,
    val currentCategory: Categories = DataSource.firstItem,
    val categoryList: List<Categories> = emptyList(),
    val currentRecommendation: Recommendations = DataSource.secondItem,
    val recommendationList: List<Recommendations> = emptyList(),
    val isShowingListPage: Boolean = true
)