// Regina Sanchez
// OSU
// CS 492

package com.example.mycity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mycity.data.DataSource
import com.example.mycity.model.Recommendations

@Composable
fun BeachClubScreen() {
    val beachClubs = DataSource.getBeachClubs()

    LazyColumn {
        items(beachClubs) { club ->
            BeachClubItem(beachClub = club)
        }
    }
}

@Composable
fun BeachClubItem(beachClub: Recommendations) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {  },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = beachClub.image),
                contentDescription = stringResource(id = beachClub.name),
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = stringResource(id = beachClub.name),
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = stringResource(id = beachClub.address),
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = stringResource(id = beachClub.description),
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}