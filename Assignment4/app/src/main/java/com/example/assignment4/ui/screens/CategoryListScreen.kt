package com.example.assignment4.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.assignment4.model.Category
import androidx.compose.material3.Text
import androidx.compose.ui.res.stringResource


//@Composable
//fun CategoryListScreen(
//    categoryList: List<Category>,
//    onCardClick: (Category) -> Unit
//) {
//    LazyColumn {
//        items(categoryList) { category ->
//            Card(
//                modifier = Modifier
//                    .padding(8.dp)
//                    .clickable { onCardClick(category) }
//            ) {
//                Text(
//                    text = stringResource(id = headerResId),
//                    modifier = Modifier.padding(16.dp)
//
//            }
//        }
//    }
//}

@Composable
fun MyText(headerResId: Int) {
    Text(
        text = stringResource(id = headerResId),  // Resolve the string resource
        modifier = Modifier.padding(16.dp)
    )
}
