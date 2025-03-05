// Regina Sanchez
// OSU
// CS 492

package com.example.mycity.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.Image
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mycity.model.Categories

@Composable
fun CategoryListScreen(
    categoryList: List<Categories>,
    modifier: Modifier = Modifier,
    onCardClick: (Categories) -> Unit,)
    {
    LazyColumn(modifier = modifier) {
        items(categoryList) { category ->
            CategoryCard(
                category = category,
                selected = false,
                onCardClick = { onCardClick(category) },
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun CategoryCard(
    category: Categories,
    selected: Boolean,
    onCardClick: (Categories) -> Unit,
    modifier: Modifier = Modifier)
    {
    Surface(
        modifier = modifier
            .clickable { onCardClick(category) }
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surface)
        {
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically)
        {
            Image(
                painter = painterResource(id = category.image),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(MaterialTheme.shapes.small))

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = stringResource(id = category.name),
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold), // Add fontWeight here
                color = MaterialTheme.colorScheme.onSurface,
            )
        }
    }
}