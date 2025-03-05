// Regina Sanchez
// OSU
// CS 492

package com.example.mycity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mycity.model.Recommendations


@Composable
fun DetailsScreen(
    recommendation: Recommendations,
    modifier: Modifier = Modifier)
    {
    Surface(
        modifier = modifier
            .padding(12.dp),
        shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colorScheme.surface)
        {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally)
            {
            Text(
                text = stringResource(id = recommendation.name),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Image(
                painter = painterResource(id = recommendation.image),
                contentDescription = stringResource(id = recommendation.name),
                modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(id = recommendation.address),
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Text(
                text = stringResource(id = recommendation.description),
            )
        }
    }
}