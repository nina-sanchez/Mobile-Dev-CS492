// Regina Sanchez
// OSU
// CS492

package com.example.treasurehunt.data

import com.example.treasurehunt.model.Rules
import com.example.treasurehunt.R

class DataSource {
    fun getRules(): List<Rules> {
        return listOf(
            Rules(titleResId = R.string.title_rule1, descriptionResId = R.string.description_rule1),
            Rules(titleResId = R.string.title_rule2, descriptionResId = R.string.description_rule2),
            Rules(titleResId = R.string.title_rule3, descriptionResId = R.string.description_rule3),
            Rules(titleResId = R.string.title_rule4, descriptionResId = R.string.description_rule4),
            Rules(titleResId = R.string.title_rule5, descriptionResId = R.string.description_rule5),
            Rules(titleResId = R.string.title_rule6, descriptionResId = R.string.description_rule6),
            Rules(titleResId = R.string.title_rule7, descriptionResId = R.string.description_rule7),
            Rules(titleResId = R.string.title_rule8, descriptionResId = R.string.description_rule8)
        )
    }
}
