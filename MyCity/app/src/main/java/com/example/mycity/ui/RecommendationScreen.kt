// Regina Sanchez
// OSU
// CS 492

package com.example.mycity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Alignment
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycity.ui.theme.MyCityTheme
import com.example.mycity.data.DataSource
import com.example.mycity.model.Recommendations
import androidx.compose.material3.Surface

@Composable
fun RecommendationListScreen(
    recommendationList: List<Recommendations>,
    onCardClick: (Recommendations) -> Unit,
    modifier: Modifier = Modifier)
    {
    LazyColumn(modifier = modifier) {
        items(recommendationList) { recommendation ->
            RecommendationCard(
                recommendation = recommendation,
                selected = false,
                onCardClick = { onCardClick(recommendation) },
                modifier = Modifier.padding(8.dp),
                key = recommendation.id
            )
        }
    }
}


@Composable
fun RecommendationCard(
    recommendation: Recommendations,
    selected: Boolean,
    onCardClick: (Recommendations) -> Unit,
    key: Int,
    modifier: Modifier = Modifier)
    {
    Surface(
        modifier = modifier
            .clickable { onCardClick(recommendation) },
        shape = MaterialTheme.shapes.medium,
        color = if (selected)
            MaterialTheme.colorScheme.primaryContainer
        else
            MaterialTheme.colorScheme.surface)
        {
        Column {
            Image(
                painter = painterResource(id = recommendation.image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )

            Text(
                text = stringResource(recommendation.name),
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecommendationCardPreview() {
    MyCityTheme {
        RecommendationCard(
            recommendation = DataSource.secondItem,
            selected = false,
            onCardClick = {},
            key = DataSource.secondItem.id
        )
    }
}